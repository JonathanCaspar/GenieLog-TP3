package GUI;

import ReservationsClient.Client;

public class ClientUI {

	private Client client;
	ClientDBObserver db;
	
	public ClientUI(Client client) {
		this.setClient(client);
		db = new ClientDBObserver();
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
		// TODO - implement ClientUI.afficherItinerairesDisponibles
		throw new UnsupportedOperationException();
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