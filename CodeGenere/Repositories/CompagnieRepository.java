package Repositories;

import java.util.*;
import CompagniesDeTransport.*;
import Transit.Lieux.Lieu;

public class CompagnieRepository extends Repository {

	protected CompagnieRepository(Scanner userInput) {
		super(userInput);
		change = false;
		idCount = 0;
		
		Compagnie com1 = new Compagnie();
		Compagnie com2 = new Compagnie();
		Compagnie com3 = new Compagnie();
		
		com1.setId(idCount);
		idCount++;
		com2.setId(idCount);
		idCount++;
		com3.setId(idCount);
		idCount++;
		
		com1.setNom("Compagnie A");
		com2.setNom("Compagnie B");
		com3.setNom("Compagnie C");
		
		com1.setSigle("AAA");
		com2.setSigle("BBB");
		com3.setSigle("CCC");
		
		compagnies = new ArrayList<Compagnie>();
		
		compagnies.add(com1);
		compagnies.add(com2);
		compagnies.add(com3);
	}
	
	List<Compagnie> compagnies;
	boolean change;
	int idCount;

	public boolean gererCompagnie() {
		boolean endCommand = true;
		String clientMenuString = "1) Créer une nouvelle compagnie\n2) Effacer une compagnie\n3) Modifier une compagnie\n4) Log Out";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4);
		while(endCommand) {
				System.out.println("Quelle opération voulez vous effectuer?\n"+ clientMenuString);
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
				switch(selection) {
					case 1:
						creer();
						break;
					case 2:
						supprimer();
						break;
					case 3:
						modifier();
						break;
					case 4:
						endCommand = false;
						break;
					default:
						
				}
			
		}
		if(change) {
			change = false;
			return true;
		}else return change;
		
	}

	@Override
	public void creer() {
		Compagnie com = new Compagnie();
		com.setId(idCount);
		idCount++;
		System.out.println("Entrer un Nom:\n");
		com.setNom(userInput.next());
		System.out.println("Entrer une Sigle:\n");
		com.setSigle(userInput.next());
		compagnies.add(com);
		change = true;
	}
	
	public String compagniePrint(Compagnie com) {
		return ("ID: " + com.getId() + " | Nom: " + com.getNom() + " | Sigle: " + com.getSigle());
	}

	public int getConsultIndex() {
		consulter();
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(0 <= selection && selection < compagnies.size())) {
					System.out.println("Selection non valide. Veuillez réessayer:\n");
					consulter();
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n");
				consulter();
			}
		}
		return selection;
	}

	@Override
	public void consulter() {
		int i = 0;
		for(Compagnie com : this.compagnies) {
			System.out.println(i + ")" + compagniePrint(com));
			i++;
		}
		
	}

	@Override
	public void modifier() {
		System.out.println("Veuiller selectioner le numéro de la compagnie é modifier:");
		int toMod = getConsultIndex();
		System.out.println("Quelle information voulez vous modifier sur: " + compagniePrint(compagnies.get(toMod)) + "?");
		System.out.println("1)Sigil\n2)Nom\n3)Annuler");
		
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(selection == 1 || selection == 2 || selection == 3)) {
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Sigil\n2)Nom\n3)Annuler");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n1)Sigil\n2)Nom\n3)Annuler");
			}
		}
		toTheNextStep = true;
				
		if(selection == 1) {
			System.out.println("Veuiller entrer un nouveau Sigil:");
			compagnies.get(toMod).setSigle(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
		}else if(selection == 2) {
			System.out.println("Veuiller entrer un nouveau Nom:");
			compagnies.get(toMod).setNom(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
		}
		else System.out.println("Modification annulée.");
		
	}

	@Override
	public void supprimer() {
		System.out.println("Veuiller selectioner le numéro du lieu à supprimer:");
		int toDelete = getConsultIndex();
		System.out.println("étes vous sér de vouloir supprimer: " + compagniePrint(compagnies.get(toDelete)) + "?");
		System.out.println("1)Oui\n2)Non");
		
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(selection == 1 || selection == 2)) {
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Oui\n2)Non");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n1)Oui\n2)Non");
			}
		}
		toTheNextStep = true;
		
		if(selection == 1) {
			compagnies.remove(toDelete);
			System.out.println("Supression réussite.");
			change = true;
		}
		else System.out.println("Supression annulée.");
		
	}

}