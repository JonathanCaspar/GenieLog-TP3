package Repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import CompagniesDeTransport.*;

public class VehiculeRepository extends Repository {

	protected VehiculeRepository(Scanner userInput) {
		super(userInput);
		//Default Data
		idCount = 0;
		Vehicule vehi1 = new Avion();
		Vehicule vehi2 = new Paquebot();
		Vehicule vehi3 = new Train();
				
		vehi1.setId(idCount);
		idCount++;
		vehi2.setId(idCount);
		idCount++;
		vehi3.setId(idCount);
		idCount++;
				
		vehicules = new ArrayList<Vehicule>();
				
		vehicules.add(vehi1);
		vehicules.add(vehi2);
		vehicules.add(vehi3);
		change = false;
	}

	ArrayList<Vehicule> vehicules;
	FabriqueVehicule fabVehi;
	boolean change;
	int idCount;

	public void creer(FabriqueVehicule fabVehi) {
		Vehicule vec = fabVehi.createVehicule(idCount);
		vec.addSections(userInput);
		vehicules.add(vec);
		idCount++;
		change = true;
	}

	public boolean gererVehicule() {
		boolean endCommand = true;
		String clientMenuString = "1) Créer un nouveau vehicule\n2) Effacer un vehicule\n3) Modifier un vehicule\n4) Log Out";
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
		String clientMenuString = "1) Avion\n2) Paquebot\n3) Train";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3);
				System.out.println("Quelle type de Vehicule voulez vous créer?\n"+ clientMenuString);
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
						creer(new FabriqueAvion(userInput));
						break;
					case 2:
						creer(new FabriquePaquebot(userInput));
						break;
					case 3:
						creer(new FabriqueTrain(userInput));
						break;
					default:
						
				}
		
	}
	
	public String vehiculePrint(Vehicule vehi) {
		return ("Id: " + vehi.getId() + " | Type: " + vehi.getVehiculeType());
	}

	public int getConsultIndex() {
		consulter();
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(0 <= selection && selection < vehicules.size())) {
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
		for(Vehicule vehi : this.vehicules) {
			System.out.println(i + ")" + vehiculePrint(vehi));
			i++;
		}
	}

	@Override
	public void modifier() {
		System.out.println("Veuiller selectioner le numéro du vehicule é modifier:");
		int toMod = getConsultIndex();
		System.out.println("Quelle modification voulez vous effectuer sur: " + vehiculePrint(vehicules.get(toMod)) + "?");
		System.out.println("1)Ajouter section\n2)Supprimer section\n3)Annuler");
		
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(selection == 1 || selection == 2 || selection == 3)) {
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Ajouter section\n2)Supprimer section\n3)Annuler");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n1)Ajouter section\n2)Supprimer section\n3)Annuler");
			}
		}
		toTheNextStep = true;
				
		if(selection == 1) {
			vehicules.get(toMod).addSections(userInput);;
			System.out.println("Modification réussite.");
			change = true;
		}else if(selection == 2) {
			System.out.println("Manque Implementation:");
			change = true;
		}
		else System.out.println("Modification annulée.");
		
	}

	@Override
	public void supprimer() {
		System.out.println("Veuiller selectioner le numéro du vehicule é supprimer:");
		int toDelete = getConsultIndex();
		System.out.println("étes vous sér de vouloir supprimer: " + vehiculePrint(vehicules.get(toDelete)) + "?");
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
			vehicules.remove(toDelete);
			System.out.println("Supression réussite.");
			change = true;
		}
		else System.out.println("Supression annulée.");
	}

}