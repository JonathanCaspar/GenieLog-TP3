package CompagniesDeTransport;

import java.util.Scanner;

public class FabriqueAvion extends FabriqueVehicule {

	public FabriqueAvion(Scanner userInput) {
		super(userInput);
	}

	public Vehicule fabricateUnit() {
		return new Avion();
	}

}