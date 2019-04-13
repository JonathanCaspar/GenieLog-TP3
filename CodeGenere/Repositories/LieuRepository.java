package Repositories;

import Transit.Lieux.*;
import java.util.*;

import GUI.RepositoryObserver;

public class LieuRepository extends Repository {

	protected LieuRepository(Scanner userInput) {
		super(userInput);
		//Default Data
		Lieu lieu1 = new Aeroport();
		Lieu lieu2 = new Port();
		Lieu lieu3 = new Gare();
		
		lieu1.setPays("Canada");
		lieu2.setPays("États-Unis");
		lieu3.setPays("Japon");
		
		lieu1.setSigle("CND");
		lieu2.setSigle("UNS");
		lieu3.setSigle("JPN");
		
		lieu1.setVille("Montréal");
		lieu2.setVille("New York");
		lieu3.setVille("Tokyo");
		lieux = new ArrayList<Lieu>();
		
		lieux.add(lieu1);
		lieux.add(lieu2);
		lieux.add(lieu3);
		
		change = false;
	}

	FabriqueLieu fabLieu;
	ArrayList<Lieu> lieux;
	boolean change;

	//Fait attention, pour les classe avec Fabrique il y a 2 methose creer. Celui la est appeler dans lautre.
	public void creer(FabriqueLieu fabLieu) {
		lieux.add(fabLieu.createLieu());
		change = true;
	}

	//La ou on prompt le user et donne les choix
	public boolean gererLieu() {
		boolean endCommand = true;
		String clientMenuString = "1) Créer un nouveau lieu\n2) Effacer un lieu\n3) Modifier un lieu\n4) Log Out";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4);
		//Tu reconnais cette structure?
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
		String clientMenuString = "1) Aéroport\n2) Port\n3) Gare";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3);
				System.out.println("Quelle type de Lieu vouvlez vous créer?\n"+ clientMenuString);
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
						creer(new FabriqueAeroport(userInput));
						break;
					case 2:
						creer(new FabriquePort(userInput));
						break;
					case 3:
						creer(new FabriqueGare(userInput));
						break;
					default:
						
				}
			
	}

	@Override
	public void consulter() {
		int i = 0;
		for(Lieu lieu : this.lieux) {
			System.out.println(i + ")" + lieuPrint(lieu));
			i++;
		}
	}
	
	public String lieuPrint(Lieu lieu) {
		return ("Sigil: " + lieu.getSigle() + " | Pays: " + lieu.getPays() + " | Ville: " + lieu.getVille());
	}

	public int getConsultIndex() {
		consulter();
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(0 <= selection && selection < lieux.size())) {
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
	public void modifier() {
		System.out.println("Veuiller selectioner le numéro du lieu à modifier:");
		int toMod = getConsultIndex();
		System.out.println("Quelle information voulez vous modifier sur: " + lieuPrint(lieux.get(toMod)) + "?");
		System.out.println("1)Sigil\n2)Pays\n3)Ville\n4)Annuler");
		
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(selection == 1 || selection == 2 || selection == 3 || selection == 4)) {
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Sigil\n2)Pays\n3)Ville\n4)Annuler");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n1)Sigil\n2)Pays\n3)Ville\n4)Annuler");
			}
		}
		toTheNextStep = true;
				
		if(selection == 1) {
			System.out.println("Veuiller entrer un nouveau Sigil:");
			lieux.get(toMod).setSigle(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
		}else if(selection == 2) {
			System.out.println("Veuiller entrer un nouveau Pays:");
			lieux.get(toMod).setPays(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
		}else if(selection == 3) {
			System.out.println("Veuiller entrer une nouvelle Ville:");
			lieux.get(toMod).setVille(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
		}
		else System.out.println("Modification annulée.");
	}

	@Override
	public void supprimer() {
		System.out.println("Veuiller selectioner le numéro du lieu à supprimer:");
		int toDelete = getConsultIndex();
		System.out.println("Êtes vous sûr de vouloir supprimer: " + lieuPrint(lieux.get(toDelete)) + "?");
		System.out.println("1)Oui\n2)Non");
		
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(selection == 1 || selection == 2)) {
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Oui\\n2)Non");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n1)Oui\\n2)Non");
			}
		}
		toTheNextStep = true;
		
		if(selection == 1) {
			lieux.remove(toDelete);
			System.out.println("Supression réussite.");
			change = true;
		}
		else System.out.println("Supression annulée.");
	}

}