package Transit.Lieux;

import java.util.Scanner;

public class FabriqueAeroport extends FabriqueLieu {

	public FabriqueAeroport(Scanner userInput) {
		super(userInput);
	}

	protected Lieu fabricateUnit() {
		return new Aeroport();
	}

}