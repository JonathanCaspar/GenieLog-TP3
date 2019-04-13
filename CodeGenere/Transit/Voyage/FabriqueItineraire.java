package Transit.Voyage;

import java.util.Scanner;

public class FabriqueItineraire extends FabriqueVoyage {

	public FabriqueItineraire(Scanner userInput) {
		super(userInput);
	}

	protected Voyage fabricateUnit() {
		return new Itineraire();
	}

}