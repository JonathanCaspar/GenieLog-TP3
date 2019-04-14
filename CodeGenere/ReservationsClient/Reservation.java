package ReservationsClient;

import java.util.*;

import com.sun.jmx.snmp.Timestamp;

import Transit.Voyage.*;

public class Reservation {

	Voyage voyageAssocie;
	private boolean confirmed;
	private Integer reservationID;
	private float balance;
	private Date heureReservation;

	public void confirmer() {
		this.confirmed = true;
	}

	public void modifier() {
		// TODO - implement Reservation.modifier
		throw new UnsupportedOperationException();
	}

	public void annuler() {
		// TODO - implement Reservation.annuler
		throw new UnsupportedOperationException();
	}

	public void setVoyage(Voyage voy) {
		this.voyageAssocie = voy;
		this.setBalance(voy.getPrix());
	}
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Integer getReservationID() {
		return reservationID;
	}

	public void setReservationID(Integer reservationID) {
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