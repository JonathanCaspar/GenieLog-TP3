package Transit.Voyage;

import java.util.Scanner;

import Repositories.Database;

public class FabriqueVol extends FabriqueVoyage {
	
	public FabriqueVol(Scanner userInput) {
		super(userInput);
	}

	protected Voyage fabricateUnit(Database db) {
		return new Vol();
	}

}