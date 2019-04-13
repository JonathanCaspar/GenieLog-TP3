package Transit.Lieux;

import java.util.Scanner;

public class FabriqueGare extends FabriqueLieu {

	public FabriqueGare(Scanner userInput) {
		super(userInput);
	}

	protected Lieu fabricateUnit() {
		return new Gare();
	}

}