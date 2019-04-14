package Transit.Voyage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Repositories.Database;
import Transit.Lieux.Lieu;


public abstract class FabriqueVoyage {

	Scanner userInput;
	public FabriqueVoyage(Scanner userInput){
		this.userInput = userInput;
	}
	
	protected abstract Voyage fabricateUnit(Database db);
	
	public Voyage createVoyage(Database db) {
		return fabricateUnit(db);
	}
	
	public int getConsultIndex(List<Lieu> current) {
		consulter(current);
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(0 <= selection && selection < current.size())) {
					System.out.println("Selection non valide. Veuillez réessayer:\n");
					consulter(current);
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n");
				consulter(current);
			}
		}
		return selection;
	}
	
	public void consulter(List<Lieu>current) {
		int i = 0;
		for(Lieu lieu : current) {
			System.out.println(i + ")" + lieuPrint(lieu));
			i++;
		}
	}
	public String lieuPrint(Lieu lieu) {
		return ("Sigle: " + lieu.getSigle() + " | Pays: " + lieu.getPays() + " | Ville: " + lieu.getVille());
	}

}