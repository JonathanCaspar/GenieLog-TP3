package Repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import CompagniesDeTransport.Compagnie;
import ReservationsClient.*;

public class ClientRepository extends Repository {

	protected ClientRepository(Scanner userInput) {
		super(userInput);
		change = false;
		idCount = 0;
		
		Client cli1 = new Client();
		Client cli2 = new Client();
		Client cli3 = new Client();
		
		cli1.setClientID(idCount);
		idCount++;
		cli2.setClientID(idCount);
		idCount++;
		cli3.setClientID(idCount);
		idCount++;
		
		cli1.setNom("Client A");
		cli2.setNom("Client B");
		cli3.setNom("Client C");
		
		cli1.setPrenom("AAA");
		cli2.setPrenom("BBB");
		cli3.setPrenom("CCC");
		
		cli1.setCourriel("AAA@AAA.AAA");
		cli2.setCourriel("BBB@BBB.BBB");
		cli3.setCourriel("CCC@CCC.CCC");
		
		cli1.setTelephone("1234567890");
		cli2.setTelephone("1234567890");
		cli3.setTelephone("1234567890");
		
		Date date = null;
		try {
			date = simpleDateFormat.parse("2019-03-08");
		}catch(ParseException e) {
			
		}
		
		cli1.setDateDeNaissance(date);
		cli2.setDateDeNaissance(date);
		cli3.setDateDeNaissance(date);
		
		cli1.setNumPasseport("ABC4567890");
		cli2.setNumPasseport("DEF4567890");
		cli3.setNumPasseport("GHI4567890");
		
		try {
			date = simpleDateFormat.parse("2022-03-08");
		}catch(ParseException e) {
			
		}
		
		
		cli1.setExpirationPasseport(date);
		cli2.setExpirationPasseport(date);
		cli3.setExpirationPasseport(date);
		
		
		clients = new ArrayList<Client>();
		
		clients.add(cli1);
		clients.add(cli2);
		clients.add(cli3);
	}
	
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	//Date date = simpleDateFormat.parse("2018-09-09");
	
	//System.out.println("Entrer une date de départ(AAAA-MM-JJ):\n");
	//Date date = simpleDateFormat.parse(userInput.next());

	List<Client> clients;

	boolean change;
	int idCount;
	
	public boolean gererClient() {
		boolean endCommand = true;
		String clientMenuString = "1) Cr�er un nouveau client\n2) Effacer un client\n3) Modifier un client\n4) Log Out";
		int selection = 0;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4);
		while(endCommand) {
				System.out.println("Quelle op�ration voulez vous effectuer?\n"+ clientMenuString);
				boolean toTheNextStep = true;
				while(toTheNextStep) {
					try {
						selection = Integer.parseInt(userInput.next());
						
						if(!selectNumber.contains(selection)) {
							System.out.println("Selection non valide. Veuillez r�essayer:\n"
									+ clientMenuString);
						}
						else toTheNextStep = false;
					}
					catch(NumberFormatException e){
						System.out.println("Selection non valide. Veuillez r�essayer:\n"
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
		Client cli1 = new Client();
		
		cli1.setClientID(idCount);
		idCount++;
		
		System.out.println("Entrer un Nom:");
		cli1.setNom(userInput.next());
		
		System.out.println("Entrer un Prenom:");
		cli1.setPrenom(userInput.next());
		
		System.out.println("Entrer un Courriel:");
		cli1.setCourriel(userInput.next());
		
		System.out.println("Entrer un Telephone:");
		cli1.setTelephone(userInput.next());
		
		System.out.println("Entrer un Date De Naissance (AAAA-MM-JJ):");
		Date date = null;
		
		boolean goodDate = true;
		while(goodDate) {
			try {
				date = simpleDateFormat.parse(userInput.next());
				goodDate = false;
			}catch(ParseException e) {
				System.out.println("Format de Date non valide. Veuillez r�essayer:");
				System.out.println("Entrer une Date De Naissance (AAAA-MM-JJ):");
			}
		}
		
		cli1.setDateDeNaissance(date);
		
		System.out.println("Entrer le Numero de Passport:");
		cli1.setNumPasseport(userInput.next());
		
		System.out.println("Entrer la Date d'Expiration du Passeport (AAAA-MM-JJ):");
		
		goodDate = true;
		while(goodDate) {
			try {
				date = simpleDateFormat.parse(userInput.next());
				goodDate = false;
			}catch(ParseException e) {
				System.out.println("Format de Date non valide. Veuillez r�essayer:");
				System.out.println("Entrer la Date d'Expiration du Passeport (AAAA-MM-JJ):");
			}
		}
		
		cli1.setExpirationPasseport(date);
		
		clients.add(cli1);
	}
	
	public String clientPrint(Client cli) {
		
		return ("ID: " + cli.getClientID() + " | Nom: " + cli.getNom() + " | Prenom: " + cli.getPrenom() + " |\n Courriel: " +  cli.getCourriel() + " |\n Telephone: " + 
				cli.getTelephone() + " |\n Date De Naissance: " + cli.getDateDeNaissance() + " |\n Date Expiration Passeport: "  + cli.getExpirationPasseport() + 
				" |\n Numero De Passport: " + cli.getNumPasseport());
	}

	public int getConsultIndex() {
		consulter();
		int selection = 0;
		boolean toTheNextStep = true;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!(0 <= selection && selection < clients.size())) {
					consulter();
					System.out.println("Selection non valide. Veuillez réessayer:");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				consulter();
				System.out.println("Selection non valide. Veuillez réessayer:");
			}
		}
		return selection;
	}

	@Override
	public void consulter() {
		int i = 0;
		for(Client cli : this.clients) {
			System.out.println(i + ")" + clientPrint(cli));
			i++;
		}
		
	}
	
	public Client getClientById(int Id) {
		for(Client cli : this.clients) {
			if(cli.getClientID() == Id) {
				return cli;
			}
		}
		return null;
		
	}

	@Override
	public void modifier() {
		System.out.println("Veuiller selectioner le numéro de la compagnie é modifier:");
		int toMod = getConsultIndex();
		System.out.println("Quelle information voulez vous modifier sur: " + clientPrint(clients.get(toMod)) + "?");
		System.out.println("1)Nom\n2)Prenom\n3)Courriel\n4)Telephone\n5)Date de naissance\n6)Numero de passport\n7)Date expiration de passport\n8)Annuler");
		
		int selection = 0;
		boolean toTheNextStep = true;
		List<Integer> selectNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				
				if(!selectNumber.contains(selection)) {
					System.out.println("Selection non valide. Veuillez réessayer:\n1)Sigil\n2)Nom\n3)Annuler");
				}
				else toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Selection non valide. Veuillez réessayer:\n1)Sigil\n2)Nom\n3)Annuler");
			}
		}
		toTheNextStep = true;
		boolean goodDate = true;
		Date date = null;
		
		switch(selection) {
		case 1:
			System.out.println("Veuiller entrer un nouveau Nom:");
			clients.get(toMod).setNom(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 2:
			System.out.println("Veuiller entrer un nouveau Prenom:");
			clients.get(toMod).setPrenom(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 3:
			System.out.println("Veuiller entrer un nouveau courriel:");
			clients.get(toMod).setCourriel(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 4:
			System.out.println("Veuiller entrer un nouveau numero de telephone:");
			clients.get(toMod).setTelephone(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 5:
			System.out.println("Entrer une Date De Naissance (AAAA-MM-JJ):");
			goodDate = true;
			date = null;
			while(goodDate) {
				try {
					date = simpleDateFormat.parse(userInput.next());
					goodDate = false;
				}catch(ParseException e) {
					System.out.println("Format de Date non valide. Veuillez r�essayer:");
					System.out.println("Entrer une Date De Naissance (AAAA-MM-JJ):");
				}
			}
			clients.get(toMod).setDateDeNaissance(date);;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 6:
			System.out.println("Veuiller entrer un nouveau Numero de Passeport:");
			clients.get(toMod).setNumPasseport(userInput.next());;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 7:
			System.out.println("Entrer la Date d'Expiration du Passeport (AAAA-MM-JJ):");
			goodDate = true;
			date = null;
			while(goodDate) {
				try {
					date = simpleDateFormat.parse(userInput.next());
					goodDate = false;
				}catch(ParseException e) {
					System.out.println("Format de Date non valide. Veuillez r�essayer:");
					System.out.println("Entrer la Date d'Expiration du Passeport (AAAA-MM-JJ):");
				}
			}
			clients.get(toMod).setExpirationPasseport(date);;
			System.out.println("Modification réussite.");
			change = true;
			break;
		case 8:
			System.out.println("Modification annulée.");
			break;
		default:
			
	}
		
	}

	@Override
	public void supprimer() {
		System.out.println("Veuiller selectioner le numéro du client à supprimer:");
		int toDelete = getConsultIndex();
		System.out.println("étes vous sér de vouloir supprimer: " + clientPrint(clients.get(toDelete)) + "?");
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
			clients.remove(toDelete);
			System.out.println("Supression réussite.");
			change = true;
		}
		else System.out.println("Supression annulée.");
		
	}

}