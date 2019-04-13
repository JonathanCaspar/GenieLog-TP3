package Repositories;

import java.util.*;

import GUI.RepositoryObserver;

public class Database extends RepositorySubject {
	
	Scanner userInput;
	//Si tu vois autre que des ArrayList, cest une erreur de vpp. Change le.
	private List<RepositoryObserver> repoObs;
	boolean change;
	
	//Nos Repository
	CompagnieRepository compagnieRepo;
	VehiculeRepository vehiculeRepo;
	ReservationRepository reservationRepo;
	LieuRepository lieuRepo;
	ClientRepository clientRepo;
	VoyageRepository voyageRepo;
	String testMessage = "nochange";
	
	public Database(Scanner userInput) {
		repoObs = new ArrayList<>();
		this.userInput = userInput;
		
		compagnieRepo = new CompagnieRepository(userInput);
		vehiculeRepo = new VehiculeRepository(userInput);
		reservationRepo = new ReservationRepository(userInput);
		lieuRepo = new LieuRepository(userInput);
		clientRepo = new ClientRepository(userInput);
		voyageRepo = new VoyageRepository(userInput);
	}
	
	//Un test juste pour voir si observer fonctionne bien(ce qui est confirmer)
	public String getTestMessageUpdate() {
		return testMessage;
	}
	//Update pour chaque repo
	public VehiculeRepository getVehiculeRepoUpdate() {
		return vehiculeRepo;
	}

	public CompagnieRepository getCompagnieRepoUpdate() {
		return compagnieRepo;
	}

	public ReservationRepository getReservationRepoUpdate() {
		return reservationRepo;
	}

	public VoyageRepository getVoyageRepoUpdate() {
		return voyageRepo;
	}

	public LieuRepository getLieuRepoUpdate() {
		return lieuRepo;
	}

	public ClientRepository getClientRepoUpdate() {
		return clientRepo;
	}
	
	//Fais aussi partie du test pour observateur 
	public String getTestUpdate() {
		return testMessage;
	}
	
	public void postTest(String a) {
		this.testMessage = a;
	}
	////////////////////////////////Methode Gerer/////////////////////////////
	
	public void gererLieuDB() {
		change = lieuRepo.gererLieu();
		subjectNotify();
	}
	
	public void gererCompagnieDB() {
		change = compagnieRepo.gererCompagnie();
		subjectNotify();
	}
	
	public void gererReservationDB() {
		change = reservationRepo.gererReservation();
		subjectNotify();
	}
	
	public void gererVehiculeDB() {
		change = vehiculeRepo.gererVehicule();
		subjectNotify();
	}
	
	public void gererClientDB() {
		change = clientRepo.gererClient();
		subjectNotify();
	}
	
	public void gererVoyageDB() {
		change = voyageRepo.gererVoyage();
		subjectNotify();
	}
	
	
	//Attach detach
	public void attach(RepositoryObserver obs) {
		if(obs == null) throw new NullPointerException("here");
		if(!repoObs.contains(obs)) {
			repoObs.add(obs);
			obs.setSubject(this);
		}
	}

	public void detach(RepositoryObserver obs) {
		repoObs.remove(obs);
	}

	public void subjectNotify() {
		if(!change) return;
		change = false;
		
		for(RepositoryObserver obs : this.repoObs) {
			obs.update();
		}
	}
	
}