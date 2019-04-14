package GUI;
import java.util.*;

import Repositories.Database;

public class MainSystem {
	public static void main(String[] args) {
		//Envoie le Scanner a chaque classe qui en a besoin apr arguement de constructeur ou methode.
		Scanner userInput = new Scanner(System.in);
		
		//Initiate
		Database database = new Database(userInput);
		AdminUI admin = new AdminUI(database);
		ClientUI client = null;
		
		//Attach observer(client only when initiated)
		database.attach(admin.getAdminObserver());
		
		int selection = 0;
		boolean toTheNextStep = true;
		
		System.out.println("Bienvenue au systeme de rservation!");
		System.out.println("Voulez vous vous connecter en tant que:\n1)Client\n2)Administrateur");
		
		//Cette structure de while revient souvent sous plusieurs variante
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(selection != 1 && selection != 2) {
					System.out.println("Selection non valide. Veuillez reessayer:\n"
							+ "Voulez vous vous connecter en tant que:\n1)Client\n2)Administrateur");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez reessayer:\n"
						+ "Voulez vous vous connecter en tant que:\n1)Client\n2)Administrateur");
			}
		}
		toTheNextStep = true;
		
		//Ce if delimite si on est client(1) ou admin(2)
		if(selection == 1) {
			//Cette partie est incomplete et est une copie de admin comme placeholder
			System.out.println("Veuiler entrer votre ID en tant que Client(Default 0):\n");
			
			boolean loggedIn = true;
			while(toTheNextStep) {
				try {
					selection = Integer.parseInt(userInput.next());
					if(admin.getClient(selection) != null) {
						toTheNextStep = false;
						client = new ClientUI(admin.getClient(selection));
						database.attach(client.getClientObserver());
					}
					else {
						toTheNextStep = true;
						loggedIn = false;
						System.out.println("ID non valide. Veuillez reessayer:\n");
					}
				}
				catch(NumberFormatException e){
					System.out.println("ID non valide. Veuillez reessayer:\n");
				}
			}
			toTheNextStep = true;
			
			if(loggedIn) {
				String clientMenuString = "1) Faire une reservation\n2) Payer une reservation\n3) Modification ou annulation de reservation\n4) Voir vos reservations\n"
						+ "5) Voir les voyages Disponibles\n6) Log Out";
				List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
				
				System.out.println("Bienvenue au systeme de reservation!\nVous etes loggue en tant que Client.");
				while(loggedIn) {
					System.out.println("Quelle operation voulez vous effectuer?\n"+ clientMenuString);
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
					switch(selection) {
						case 1:
							client.reserver();
							break;
						case 2:
							client.payer();
							break;
						case 3:
							client.modifierAnnulerReservation();
							break;
						case 4:
							client.afficherReservations();
							break;
						case 5:
							client.afficherVoyagesDisponibles();
							break;
						case 6:
							loggedIn = false;
							break;
						default:
							
					}
				
				}
			}
			else {
				System.out.println("ID invalide. Systeme shut down...\n");
			}
			
		}
		else {
			//Menu admin
			String adminMenuString = "1) Gestion de Lieux\n2) Gestion de Compagnies\n3) Gestion de Clients\n4) Gestion de Voyages\n"
					+ "5) Gestion de Vehicules\n6) Gestion de Reservation\n7) Voir sommaire des itineraires\n8)Log Out";
			//Ajouter les nmero de selection a selectNumber quand il y a nouvelle option
			List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
			
			System.out.println("Bienvenue au systeme de reservation!\nVous etes loggue en tant que Administrateur.");
			boolean loggedIn = true;  //Est false losquon veut logout
			while(loggedIn) {
				System.out.println("Quelle operation voulez vous effectuer?\n"+ adminMenuString);
				//La fameuse while
				while(toTheNextStep) {
					try {
						selection = Integer.parseInt(userInput.next());
						
						if(!selectNumber.contains(selection)) {
							System.out.println("Selection non valide. Veuillez reessayer:\n"
									+ adminMenuString);
						}
						else toTheNextStep = false;
					}
					catch(NumberFormatException e){
						System.out.println("Selection non valide. Veuillez reessayer:\n"
								+ adminMenuString);
					}
				}
				toTheNextStep = true;
				//Cest admin qui enclanche loperation mais c bien sur pas lui qui fais le operation. Pour savoir qui fait les operation,
				//faire le suivi des fonction.
				//Ex:admin.gererLieu() (AdminUI)-> 
				//adminInvo.setCommand(new GererLieu(db.getSubjectReference())) (AdminUI)-> 
				//adminInvo.executeCommand(); (AdminUI)-> 
				//receiver.gererLieuDB(); (GererLieu)->
				//lieuRepo.gererLieu(); (Database)
				switch(selection) {
					case 1:
						admin.gererLieu();
						break;
					case 2:
						admin.gererCompagnie();
						break;
					case 3:
						admin.gererClient();
						break;
					case 4:
						admin.gererVoyage();
						break;
					case 5:
						admin.gererVehicule();
						break;
					case 6:
						admin.gererReservation();
						break;
					case 7:
						admin.voirSommaireItineraires();
						break;
					case 8:
						loggedIn = false;
						break;
					default:
						
				}
			}
			
		}
		
		
		System.out.println("Deconnection complete. A la prochaine!");
		/*
		System.out.println("Test input:");
		String input = userInput.nextLine();
		System.out.println("Input :" + input);
		userInput.close();
		*/
	}
	
	
}