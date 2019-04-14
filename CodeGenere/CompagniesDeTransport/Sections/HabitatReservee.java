package CompagniesDeTransport.Sections;

import ReservationsClient.*;

public class HabitatReservee implements HabitatState {

	@Override
	public Reservation reserver(Habitat habitat) {
		System.out.println("La réservation de cet habitat est impossible car il est deja réservé mais il pourrait se libérer sous 24h.");
		return null;
	}

}