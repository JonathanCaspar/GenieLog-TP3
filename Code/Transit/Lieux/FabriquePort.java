package Transit.Lieux;

import java.util.Scanner;

public class FabriquePort extends FabriqueLieu {

	public FabriquePort(Scanner userInput) {
		super(userInput);
	}

	protected Lieu fabricateUnit() {
		return new Port();
	}

}