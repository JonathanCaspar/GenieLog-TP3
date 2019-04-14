package CompagniesDeTransport;

import java.util.*;

import CompagniesDeTransport.Sections.*;
import Transit.Voyage.*;

public class Avion extends Vehicule {

	Collection<Vol> voyagesAffectes;

	public Avion() {
		super();
		initSection();
	}

	public void initSection() {
		sections.add(new SectionAffaire());
	}

	@Override
	public String getVehiculeType() {
		return "Avion";
	}
	
	public void addSections(Scanner userInput) {
		String clientMenuString = "1) Affaire\n2) Premiere\n3) EcoPlus\n4)Economique";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4);
				System.out.println("Quelle type de Section voulez vous creer?\n"+ clientMenuString);
				boolean toTheNextStep = true;
				while(toTheNextStep) {
					try {
						selection = Integer.parseInt(userInput.next());
						
						if(!selectNumber.contains(selection)) {
							System.out.println("Selection non valide. Veuillez reessayer:\n"
									+ clientMenuString);
						}
						else toTheNextStep = false;
					}
					catch(NumberFormatException e){
						System.out.println("Selection non valide. Veuillez reessayer:\n"
								+ clientMenuString);
					}
				}
				toTheNextStep = true;
				SectionSieges sec;
				System.out.println("Quel est le nombre de siege?\n");
				switch(selection) {
					case 1:
						sec = new SectionAffaire();
						sec.setNbSieges(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 2:
						sec = new SectionPremiere();
						sec.setNbSieges(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 3:
						sec = new SectionEcoPlus();
						sec.setNbSieges(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					case 4:
						sec = new SectionEconomique();
						sec.setNbSieges(acceptSiegeNb(userInput));
						sections.add(sec);
						break;
					default:
						
				}
	}

}