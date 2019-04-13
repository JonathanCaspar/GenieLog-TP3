package CompagniesDeTransport;

import java.util.*;

import CompagniesDeTransport.Sections.*;
import Transit.Voyage.*;

public class Paquebot extends Vehicule {

	Collection<Croisiere> voyagesAffectes;

	public Paquebot() {
		super();
		initSection();
	}

	public void initSection() {
		sections.add(new CabineFamille());
	}

	@Override
	public String getVehiculeType() {
		return "Paquebot";
	}

	public void addSections(Scanner userInput) {
		String clientMenuString = "1) Famille Deluxe\n2) Famille\n3) Suite\n4)Vue Sur Ocean\n5)Interieur";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4, 5);
				System.out.println("Quelle type de Section voulez vous créer?\n"+ clientMenuString);
				boolean toTheNextStep = true;
				while(toTheNextStep) {
					try {
						selection = Integer.parseInt(userInput.next());
						
						if(!selectNumber.contains(selection)) {
							System.out.println("Selection non valide. Veuillez réessayer:\n"
									+ clientMenuString);
						}
						else toTheNextStep = false;
					}
					catch(NumberFormatException e){
						System.out.println("Selection non valide. Veuillez réessayer:\n"
								+ clientMenuString);
					}
				}
				toTheNextStep = true;
				SectionCabines sec;
				System.out.println("Quelle est le nombre de cabine?\n");
				switch(selection) {
					case 1:
						sec = new CabineFamilleDeluxe();
						sec.setNbCabines(acceptSiegeNb(userInput));
						System.out.println("Quelle est la capacité?\n");
						sec.setCapacité(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 2:
						sec = new CabineFamille();
						sec.setNbCabines(acceptSiegeNb(userInput));
						System.out.println("Quelle est la capacité?\n");
						sec.setCapacité(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 3:
						sec = new CabineSuite();
						sec.setNbCabines(acceptSiegeNb(userInput));
						System.out.println("Quelle est la capacité?\n");
						sec.setCapacité(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 4:
						sec = new CabineVueSurOcean();
						sec.setNbCabines(acceptSiegeNb(userInput));
						System.out.println("Quelle est la capacité?\n");
						sec.setCapacité(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 5:
						sec = new CabineInterieur();
						sec.setNbCabines(acceptSiegeNb(userInput));
						System.out.println("Quelle est la capacité?\n");
						sec.setCapacité(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					default:
						
				}
	}

}