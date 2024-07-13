package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	/* por que estou colocando sfd em static.  Para que não seja instaciado um novo SimpleDateFormat para cada objeto reservation que
	 * minha aplicação estiver eu irei precisar de apenas um por isso foi colocado como static   */ 
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
	if (!checkOut.after(checkIn)) {
			
			throw new DomainException (" Check-out date must be after check-in date");
			
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration () {
		/* calculando as datas em milisegundos */
		long diff = checkOut.getTime() - checkIn.getTime();
		/* getTime que me devolve a quantidade de miliseundos daquela data com isso pega as duas datas em milisegundos */
		
		
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		/* para converter em dias  */ 
		
	}
	/* Adicionado o update para adicionar duas novas datas e vai atualizar o checkIn e checkOut */
	public void updateDates (Date checkIn , Date checkOut) {
		
		Date now = new Date();
		/* before e anterior */
		if (checkIn.before(now) || checkOut.before(now)) {
		throw new DomainException ("Reservation dates for update must be future dates");

		} 
		
		if (!checkOut.after(checkIn)) {
			
			throw new DomainException (" Check-out date must be after check-in date");
			
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Room"
				+roomNumber
				+", check-in:"
				+sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+"nigths";
	}

}
