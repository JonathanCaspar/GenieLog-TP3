package GUI;

import ReservationsClient.Client;
import Visitor.*;

public class ClientUI {

	private Client client;
	ClientDBObserver db;
	ClientVoyageVisitor clientVisit;
	
	public ClientUI(Client client) {
		this.setClient(client);
		db = new ClientDBObserver("client");
		clientVisit = new ClientVoyageVisitor();
	}

	public void reserver() {
		// TODO - implement ClientUI.reserver
		throw new UnsupportedOperationException();
	}

	public void payer() {
		// TODO - implement ClientUI.payer
		throw new UnsupportedOperationException();
	}

	public void modifierAnnulerReservation() {
		// TODO - implement ClientUI.modifierAnnulerReservation
		throw new UnsupportedOperationException();
	}

	public void afficherReservations() {
		// TODO - implement ClientUI.afficherReservations
		throw new UnsupportedOperationException();
	}

	public void afficherVoyagesDisponibles() {
		db.getVoyageRepo().getSummary(clientVisit);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public ClientDBObserver getClientObserver() {
		return this.db;
	}

}