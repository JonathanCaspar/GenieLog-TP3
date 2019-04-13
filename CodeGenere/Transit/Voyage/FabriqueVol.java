package Transit.Voyage;

import java.util.Scanner;

public class FabriqueVol extends FabriqueVoyage {
	
	public FabriqueVol(Scanner userInput) {
		super(userInput);
	}

	protected Voyage fabricateUnit() {
		return new Vol();
	}

}