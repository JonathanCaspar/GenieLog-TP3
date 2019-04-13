package GUI;

import Repositories.Database;
import ReservationsClient.Client;

public class AdminUI {
	
	AdminInvoker adminInvo;
	AdminDBObserver db;
	
	//constructeur
	public AdminUI(Database localDB) {
		adminInvo = new AdminInvoker();
		db = new AdminDBObserver("admin");
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
		// TODO - implement AdminUI.gererVoyage
		throw new UnsupportedOperationException();
	}

	public void gererVehicule() {
		adminInvo.setCommand(new GererVehicule(db.getSubjectReference()));
		adminInvo.executeCommand();
	}

	public void gererClient() {
		// TODO - implement AdminUI.gererClient
		throw new UnsupportedOperationException();
	}

	public void gererReservation() {
		// TODO - implement AdminUI.gererReservation
		throw new UnsupportedOperationException();
	}

	public void voirSommaireItineraires() {

	}

	public void voirItinerairesDetailles() {

	}

	public void getReservation() {

	}
	
	public Client getClient(int clientID) {
		return null;
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