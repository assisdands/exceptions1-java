package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program4 {

	public static void main(String[] args) throws ParseException {
		
		//Sem throws ParseException, eu digo que o meu m�todo main � normal e n�o lan�a excec�o alguma. Quando eu coloco um m�todo uma chamada que pode chamar exce��o, o compilador ir� reclamar: ou voc� trata essa exce��o ou propaga ela no m�todo onde estou. Como estou no m�todo main(public static void main(...), quando eu lan�o o throws ParseException, eu digo o meu m�todo pode lan�ar uma exce��o desse tipo.
		//Estou dizendo que o meu m�todo main n�o tem que tratar esse tipo de exce��o, se esse tipo de exce��o acontecer, no meio do m�todo, essa exce��o ser� propagada nesse m�todo. Eventualmente um m�todo que chamasse esse main, teria que tratar essa exce��o da mesma forma ou propagar tamb�m. (pilha de chamada de m�todos) 
		
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
