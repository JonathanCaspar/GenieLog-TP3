package CompagniesDeTransport;

import java.util.Scanner;

public class FabriquePaquebot extends FabriqueVehicule {

	public FabriquePaquebot(Scanner userInput) {
		super(userInput);
	}

	public Vehicule fabricateUnit() {
		return new Paquebot();
	}

}