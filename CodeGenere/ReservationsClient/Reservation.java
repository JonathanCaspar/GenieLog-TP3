package ReservationsClient;

import java.util.*;

import com.sun.jmx.snmp.Timestamp;

import CompagniesDeTransport.Sections.Habitat;

public class Reservation {

	Habitat habitatAssocie;
	private boolean confirmed;
	private String reservationID;
	private float balance;
	private Date heureReservation;

	public void confirmer() {
		this.confirmed = true;
	}

	public void modifier() {
		// TODO - implement Reservation.modifier
		throw new UnsupportedOperationException();
	}

	public Reservation(Habitat habitatAssocie) {
		super();
		this.habitatAssocie = habitatAssocie;
		this.balance = habitatAssocie.getPrix();
		this.confirmed = false;
		this.reservationID = UUID.randomUUID().toString();
		this.heureReservation = new Date();
	}

	public void annuler() {
		// TODO - implement Reservation.annuler
		throw new UnsupportedOperationException();
	}

	public void setHabitat(Habitat habitatAssocie) {
		this.habitatAssocie = habitatAssocie;
		this.setBalance(habitatAssocie.getPrix());
	}
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getReservationID() {
		return reservationID;
	}

	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Date getHeureReservation() {
		return heureReservation;
	}

	public void setHeureReservation(Date heureReservation) {
		this.heureReservation = heureReservation;
	}

}