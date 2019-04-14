package CompagniesDeTransport.Sections;

import ReservationsClient.*;

public class HabitatDisponible implements HabitatState{

	public Reservation reserver(Habitat habitat) {
		
		System.out.println("La réservation est effectuée.");
		return new Reservation(habitat);
		
	}

}