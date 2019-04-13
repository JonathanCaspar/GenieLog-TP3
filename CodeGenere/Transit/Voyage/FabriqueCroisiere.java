package Transit.Voyage;

import java.util.Scanner;

public class FabriqueCroisiere extends FabriqueVoyage {

	public FabriqueCroisiere(Scanner userInput) {
		super(userInput);
	}

	protected Voyage fabricateUnit() {
		return new Croisiere();
	}

}