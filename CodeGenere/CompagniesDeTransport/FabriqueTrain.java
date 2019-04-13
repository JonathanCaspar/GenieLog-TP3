package CompagniesDeTransport;

import java.util.Scanner;

public class FabriqueTrain extends FabriqueVehicule {

	public FabriqueTrain(Scanner userInput) {
		super(userInput);
	}

	public Vehicule fabricateUnit() {
		return new Train();
	}

}