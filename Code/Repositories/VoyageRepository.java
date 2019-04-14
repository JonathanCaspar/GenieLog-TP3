package Repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import GUI.AdminDBObserver;
import ReservationsClient.Client;
import Visitor.*;
import Transit.Lieux.Lieu;
import Transit.Voyage.*;

public class VoyageRepository extends Repository {

	protected VoyageRepository(Scanner userInput, Database db) {
		super(userInput);
		change = false;
		this.db = db;
		
		Voyage voy1 = new Vol();
		Voyage voy2 = new Itineraire();
		Voyage voy3 = new Croisiere();
		
		voy1.setId("VL123");
		voy2.setId("IT456");
		voy3.setId("CS789");
		
		voy1.setLieuDepart(db.getLieuRepoUpdate().getLieuByVille("Montreal"));
		voy2.setLieuDepart(db.getLieuRepoUpdate().getLieuByVille("New York"));
		voy3.setLieuDepart(db.getLieuRepoUpdate().getLieuByVille("Tokyo"));
		
		voy1.setLieuArrivee(db.getLieuRepoUpdate().getLieuByVille("Tokyo"));
		voy2.setLieuArrivee(db.getLieuRepoUpdate().getLieuByVille("Montreal"));
		voy3.setLieuArrivee(db.getLieuRepoUpdate().getLieuByVille("New York"));
		
		voy1.setPrix(50);
		voy2.setPrix(50);
		voy3.setPrix(50);
		
		Date date = null;
		try {
			date = simpleDateFormat.parse("2019-03-08 12:00:00");
		}catch(ParseException e) {
			
		}
		
		voy1.setDateDepart(date);
		voy2.setDateDepart(date);
		voy3.setDateDepart(date);
		
		try {
			date = simpleDateFormat.parse("2022-03-08 23:00:00");
		}catch(ParseException e) {
			
		}
		
		voy1.setDateArrivee(date);
		voy2.setDateArrivee(date);
		voy3.setDateArrivee(date);
		
		
		voyages = new ArrayList<Voyage>();
		
		voyages.add(voy1);
		voyages.add(voy2);
		voyages.add(voy3);
	}

	List<Voyage> voyages;
	FabriqueVoyage fabVoy;
	boolean change;
	Database db;
	String pattern = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public void creer(FabriqueVoyage fabVoy) {
		Voyage voy = fabVoy.createVoyage(db);
		
		System.out.println("Entrer un id:");
		voy.setId(userInput.next());
		
		System.out.println("Entrer un Lieu de Depart:");
		boolean goodReply = true;
		Lieu temp = null;
		
		while(goodReply) {
			temp = db.getLieuRepoUpdate().getLieuByVille(userInput.next());
			if(temp != null) {
				voy.setLieuDepart(temp);
				goodReply = false;
			}
			else {
				System.out.println("Lieu de Depart invalide. Veuiller reessayer:");
				System.out.println("Entrer un Lieu de Depart:");
			}
		}
		
		System.out.println("Entrer un Lieu d'ArrivÈ:");
		goodReply = true;
		while(goodReply) {
			temp = db.getLieuRepoUpdate().getLieuByVille(userInput.next());
			if(temp != null) {
				voy.setLieuArrivee(temp);
				goodReply = false;
			}
			else {
				System.out.println("Lieu d'ArrivÈ invalide. Veuiller reessayer:");
				System.out.println("Entrer un Lieu d'ArrivÈ:");
			}
		}
		
		System.out.println("Entrer un Prix:\n");
		goodReply = true;
		float prix = 0;
		while(goodReply) {
			try {
				prix = Float.parseFloat(userInput.next());
				goodReply = false;
			}
			catch(NumberFormatException e){
				System.out.println("Prix non valide. Veuillez reessayer:");
			}
		}
		voy.setPrix(prix);
		
		System.out.println("Entrer une Date de Depart:");
		Date date = null;
		
		goodReply = true;
		while(goodReply) {
			try {
				System.out.println("Entrer une Date de Depart(yyyy-MM-dd):");
				String h = userInput.next();
				System.out.println("Entrer l'Heure de Depart(HH:mm:ss):");
				String j = userInput.next();
				h = h + " " + j;
				date = simpleDateFormat.parse(h);
				goodReply = false;
			}catch(ParseException e) {
				System.out.println("Format de date non valide. Veuillez reessayer:");
				System.out.println("Entrer une Date de Depart:");
			}
		}
		voy.setDateDepart(date);
		
		System.out.println("Entrer une Date d'ArrivÈ:");
		goodReply = true;
		while(goodReply) {
			try {
				System.out.println("Entrer une Date d'ArrivÈ(yyyy-MM-dd):");
				String h = userInput.next();
				System.out.println("Entrer l'Heure d'ArrivÈ(HH:mm:ss):");
				String j = userInput.next();
				h = h + " " + j;
				date = simpleDateFormat.parse(h);
				goodReply = false;
			}catch(ParseException e) {
				System.out.println("Format de date non valide. Veuillez reessayer:");
				System.out.println("Entrer une Date d'ArrivÈ:");
			}
		}
		
		voy.setDateArrivee(date);
		
		voyages.add(voy);
		change = true;
	}

	public boolean gererVoyage(AdminDBObserver obs) {
		db = obs.getSubjectReference();
		boolean endCommand = true;
		String clientMenuString = "1) Cr√©er un nouveau voyage\n2) Effacer un voyage\n3) Modifier un voyage\n4) Log Out";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4);
		//Tu reconnais cette structure?
		while(endCommand) {
				System.out.println("Quelle op√©ration voulez vous effectuer?\n"+ clientMenuString);
				boolean toTheNextStep = true;
				while(toTheNextStep) {
					try {
						selection = Integer.parseInt(userInput.next());
						
						if(!selectNumber.contains(selection)) {
							System.out.println("Selection non valide. Veuillez r√©essayer:\n"
									+ clientMenuString);
						}
						else toTheNextStep = false;
					}
					catch(NumberFormatException e){
						System.out.println("Selection non valide. Veuillez r√©essayer:\n"
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

	/**
	 * 
	 * @param visitor
	 */
	public void getSummary(VoyageVisitor visitor) {
		int i = 0;
		for(Voyage voy : this.voyages) {
			voy.accept(visitor);
		}
	}

	@Override
	public void creer() {
		String clientMenuString = "1) Vol\n2) Itineraire\n3) Croisiere";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3);
				System.out.println("Quelle type de Voyage voulez vous cr√©er?\n"+ clientMenuString);
				boolean toTheNextStep = true;
				while(toTheNextStep) {
					try {
						selection = Integer.parseInt(userInput.next());
						
						if(!selectNumber.contains(selection)) {
							System.out.println("Selection non valide. Veuillez r√©essayer:\n"
									+ clientMenuString);
						}
						else toTheNextStep = false;
					}
					catch(NumberFormatException e){
						System.out.println("Selection non valide. Veuillez r√©essayer:\n"
								+ clientMenuString);
					}
				}
				toTheNextStep = true;
				switch(selection) {
					case 1:
						creer(new FabriqueVol(userInput));
						break;
					case 2:
						creer(new FabriqueItineraire(userInput));
						break;
					case 3:
						creer(new FabriqueCroisiere(userInput));
						break;
					default:
						
				}
	}
	
	public String voyagePrint(Voyage voy) {
		return ("ID: " + voy.getId() + " | Lieu de Depart: " + voy.getLieuDepart().getVille() + " | Date de Depart: " + voy.getDateDepart() + " |\n Lieu d'ArrivÈ: " +  voy.getLieuArrivee().getVille() + " |\n Date d'ArrivÈ: " + 
				voy.getDateArrivee() + " |\n Prix: " + voy.getPrix());
	}

	public int getConsultIndex() {
		consulter();
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(0 <= selection && selection < voyages.size())) {
					consulter();
					System.out.println("Selection non valide. Veuillez r√©essayer:");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				consulter();
				System.out.println("Selection non valide. Veuillez r√©essayer:");
			}
		}
		return selection;
	}

	@Override
	public void consulter() {
		int i = 0;
		for(Voyage voy : this.voyages) {
			System.out.println(i + ")" + voyagePrint(voy));
			i++;
		}
	}

	@Override
	public void modifier() {
		System.out.println("Veuiller selectioner le num√©ro du voyage √© modifier:");
		int toMod = getConsultIndex();
		System.out.println("Quelle information voulez vous modifier sur: " + voyagePrint(voyages.get(toMod)) + "?");
		System.out.println("1)Id\n2)Lieu de Depart\n3)Date de Depart\n4)Lieu d'ArrivÈ\n5)Date d'ArrivÈ\n6)Prix\n7)Annuler");
		
		int selection = 0;
		boolean toTheNextStep = true;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!selectNumber.contains(selection)) {
					System.out.println("Selection non valide. Veuillez r√©essayer:");
					System.out.println("1)Id\n2)Lieu de Depart\n3)Date de Depart\n4)Lieu d'ArrivÈ\n5)Date d'ArrivÈ\n6)Prix\n7)Annuler");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez r√©essayer:");
				System.out.println("1)Id\n2)Lieu de Depart\n3)Date de Depart\n4)Lieu d'ArrivÈ\n5)Date d'ArrivÈ\n6)Prix\n7)Annuler");
			}
		}
		toTheNextStep = true;
		Date date = null;
		boolean goodReply = true;
		Lieu temp = null;
		
		switch(selection) {
		case 1:
			System.out.println("Veuiller entrer un nouveau Id:");
			voyages.get(toMod).setId(userInput.next());;
			System.out.println("Modification r√©ussite.");
			change = true;
			break;
		case 2:
			System.out.println("Veuiller entrer un nouveau Lieu de Depart:");
			goodReply = true;
			while(goodReply) {
				temp = db.getLieuRepoUpdate().getLieuByVille(userInput.next());
				if(temp != null) {
					voyages.get(toMod).setLieuDepart(temp);;
					goodReply = false;
				}
				else {
					System.out.println("Lieu de Depart invalide. Veuiller reessayer:");
					System.out.println("Entrer un nouveau Lieu de Depart:");
				}
			}
			System.out.println("Modification r√©ussite.");
			change = true;
			break;
		case 3:
			System.out.println("Veuiller entrer une nouvelle Date de Depart:");
			goodReply = true;
			while(goodReply) {
				try {
					System.out.println("Entrer une Date de Depart(yyyy-MM-dd):");
					String h = userInput.next();
					System.out.println("Entrer l'Heure de Depart(HH:mm:ss):");
					String j = userInput.next();
					h = h + " " + j;
					date = simpleDateFormat.parse(h);
					voyages.get(toMod).setDateDepart(date);
					goodReply = false;
				}catch(ParseException e) {
					System.out.println("Format de date non valide. Veuillez reessayer:");
					System.out.println("Entrer une nouvelle Date de Depart:");
				}
			}
			System.out.println("Modification r√©ussite.");
			change = true;
			break;
		case 4:
			System.out.println("Veuiller entrer un nouveau Lieu d'ArrivÈ:");
			goodReply = true;
			while(goodReply) {
				temp = db.getLieuRepoUpdate().getLieuByVille(userInput.next());
				if(temp != null) {
					voyages.get(toMod).setLieuArrivee(temp);;
					goodReply = false;
				}
				else {
					System.out.println("Lieu d'ArrivÈ invalide. Veuiller reessayer:");
					System.out.println("Entrer un nouveau Lieu d'ArrivÈ:");
				}
			}
			System.out.println("Modification r√©ussite.");
			change = true;
			break;
		case 5:
			System.out.println("Veuiller entrer une nouvelle Date d'ArrivÈ:");
			goodReply = true;
			while(goodReply) {
				try {
					System.out.println("Entrer une Date d'ArrivÈ(yyyy-MM-dd):");
					String h = userInput.next();
					System.out.println("Entrer l'Heure d'ArrivÈ(HH:mm:ss):");
					String j = userInput.next();
					h = h + " " + j;
					date = simpleDateFormat.parse(h);
					voyages.get(toMod).setDateDepart(date);
					goodReply = false;
				}catch(ParseException e) {
					System.out.println("Format de date non valide. Veuillez reessayer:");
					System.out.println("Entrer une nouvelle Date d'ArrivÈ:");
				}
			}
			System.out.println("Modification r√©ussite.");
			change = true;
			break;
		case 6:
			System.out.println("Entrer un nouveau Prix:\n");
			goodReply = true;
			float prix = 0;
			while(goodReply) {
				try {
					prix = Float.parseFloat(userInput.next());
					voyages.get(toMod).setPrix(prix);
					goodReply = false;
				}
				catch(NumberFormatException e){
					System.out.println("Prix non valide. Veuillez reessayer:");
				}
			}
			System.out.println("Modification r√©ussite.");
			change = true;
			break;
		case 7:
			System.out.println("Modification annul√©e.");
			break;
		default:
			
	}
	}

	@Override
	public void supprimer() {
		System.out.println("Veuiller selectioner le num√©ro du client √† supprimer:");
		int toDelete = getConsultIndex();
		System.out.println("√©tes vous s√©r de vouloir supprimer: " + voyagePrint(voyages.get(toDelete)) + "?");
		System.out.println("1)Oui\n2)Non");
		
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(selection == 1 || selection == 2)) {
					System.out.println("Selection non valide. Veuillez r√©essayer:\n1)Oui\n2)Non");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez r√©essayer:\n1)Oui\n2)Non");
			}
		}
		toTheNextStep = true;
		
		if(selection == 1) {
			voyages.remove(toDelete);
			System.out.println("Supression r√©ussite.");
			change = true;
		}
		else System.out.println("Supression annul√©e.");
	}

}