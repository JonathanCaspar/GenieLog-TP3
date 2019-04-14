package CompagniesDeTransport.Sections;

import ReservationsClient.*;

public class HabitatConfirmee implements HabitatState {

	public Reservation reserver(Habitat habitat) {
		System.out.println("La réservation de cet habitat est impossible car il est deja pris.");
		return null;
	}

}