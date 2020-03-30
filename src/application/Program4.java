package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program4 {

	public static void main(String[] args) throws ParseException {
		
		//Sem throws ParseException, eu digo que o meu método main é normal e não lança excecão alguma. Quando eu coloco um método uma chamada que pode chamar exceção, o compilador irá reclamar: ou você trata essa exceção ou propaga ela no método onde estou. Como estou no método main(public static void main(...), quando eu lanço o throws ParseException, eu digo o meu método pode lançar uma exceção desse tipo.
		//Estou dizendo que o meu método main não tem que tratar esse tipo de exceção, se esse tipo de exceção acontecer, no meio do método, essa exceção será propagada nesse método. Eventualmente um método que chamasse esse main, teria que tratar essa exceção da mesma forma ou propagar também. (pilha de chamada de métodos) 
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.println("Check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now) ) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
			}
		}
		
		sc.close();
		
		
	}
	
	

}
