package Transit.Voyage;

import java.util.*;

import Repositories.Database;
import Transit.Lieux.Lieu;
import Transit.Lieux.Port;

public class FabriqueCroisiere extends FabriqueVoyage {

	public FabriqueCroisiere(Scanner userInput) {
		super(userInput);
	}

	protected Voyage fabricateUnit(Database db) {
		Croisiere croi = new Croisiere();
		System.out.println("Choisiser le port de depart:");
		List<Lieu> portCurrent = db.getLieuRepoUpdate().getPort();
		int select = getConsultIndex(portCurrent);
		croi.setPortDA((Port)portCurrent.get(select));
		
		
		boolean done = true;
		while(done) {
			System.out.println("Choisiser les ports intermediaire:");
			select = getConsultIndex(portCurrent);
			croi.addPortInt((Port)portCurrent.get(select));
			System.out.println("Voulez vous en ajouter un autre?\n1)Oui\n2)Non");
			int selection = 0;
			boolean toTheNextStep = true;
			while(toTheNextStep) {
				try {
					selection = Integer.parseInt(userInput.next());
					
					if(!(selection == 1 || selection == 2)) {
						System.out.println("Selection non valide. Veuillez réessayer:\n1)Ouin2)Non");
					}
					else toTheNextStep = false;
				}
				catch(NumberFormatException e){
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Oui\n2)Non");
				}
			}
			
			if(selection == 1) {
				
			}else done = false;
		}
		
		return croi;
	}
	
	

}