package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class solucao1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		
        try {
		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sfd.parse(sc.next());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sfd.parse(sc.next());

		
			/* caso contrario instanciei a minha reserva */
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sfd.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sfd.parse(sc.next());
			
		     reservation.updateDates(checkIn, checkOut);
			 System.out.println("Reservation " + reservation);
        }
        catch (ParseException e) {
        	System.out.println("Ivalid date format");
        }
        catch (DomainException e ) {
        	System.out.println("Error in reservation: " + e.getMessage());
        	/* Esse e.getMessage()) e essa mensagem passada 
        	 * throw new IllegalArgumentException ("Reservation dates for update must be future dates.");    */
        }
			catch (RuntimeException e ) {
				System.out.println("Unexpected error! ");
			}

		sc.close();

	}

}
