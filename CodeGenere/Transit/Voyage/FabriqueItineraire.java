package Transit.Voyage;

import java.util.List;
import java.util.Scanner;

import Repositories.Database;
import Transit.Lieux.*;



public class FabriqueItineraire extends FabriqueVoyage {

	public FabriqueItineraire(Scanner userInput) {
		super(userInput);
	}

	protected Voyage fabricateUnit(Database db) {
		Itineraire itin = new Itineraire();
		System.out.println("Choisiser la gare de depart:");
		List<Lieu> gareCurrent = db.getLieuRepoUpdate().getGare();
		int select = getConsultIndex(gareCurrent);
		itin.setGareD((Gare)gareCurrent.get(select));
		
		
		boolean done = true;
		while(done) {
			System.out.println("Choisiser les gares intermediaire:");
			select = getConsultIndex(gareCurrent);
			itin.addGareInt((Gare)gareCurrent.get(select));
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
		
		return itin;
	}

}