package GUI;

import Repositories.ClientRepository;
import Repositories.Database;
import ReservationsClient.Client;
import Visitor.AdminVoyageVisitor;

public class AdminUI {
	
	AdminInvoker adminInvo;
	AdminDBObserver db;
	AdminVoyageVisitor adminVisit;
	
	//constructeur
	public AdminUI(Database localDB) {
		adminInvo = new AdminInvoker();
		db = new AdminDBObserver("admin");
		adminVisit = new AdminVoyageVisitor();
	}
	
	//Prend gererLieu comme exemple de structure. Il y a aussi compagnie et vehicule qui fonctionnent
	public void gererLieu() {
		adminInvo.setCommand(new GererLieu(db.getSubjectReference()));
		adminInvo.executeCommand();
	}

	public void gererCompagnie() {
		adminInvo.setCommand(new GererCompagnie(db.getSubjectReference()));
		adminInvo.executeCommand();
	}

	public void gererVoyage() {
		adminInvo.setCommand(new GererVoyage(db.getSubjectReference(), db));
		adminInvo.executeCommand();
	}

	public void gererVehicule() {
		adminInvo.setCommand(new GererVehicule(db.getSubjectReference()));
		adminInvo.executeCommand();
	}

	public void gererClient() {
		adminInvo.setCommand(new GererClient(db.getSubjectReference()));
		adminInvo.executeCommand();
	}

	public void gererReservation() {
		// TODO - implement AdminUI.gererReservation
		throw new UnsupportedOperationException();
	}

	public void voirSommaireItineraires() {
		db.getVoyageRepo().getSummary(adminVisit);
	}

	public void voirItinerairesDetailles() {

	}

	public void getReservation() {

	}
	
	public Client getClient(int clientID) {
		return db.getClientRepo().getClientById(clientID);
	}
	
	public AdminDBObserver getAdminObserver() {
		return this.db;
	}

	/**
	 * 
	 * @param IReservable
	 */
	public void verifierSiReservable(int IReservable) {
		// TODO - implement AdminUI.verifierSiReservable
		throw new UnsupportedOperationException();
	}


}