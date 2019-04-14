package GUI;

import Repositories.*;

public class ClientDBObserver extends RepositoryObserver {

	private VoyageRepository voyageRepo;
	private ReservationRepository reservationRepo;
	String name;
	Database subject;
	
	public ClientDBObserver(String name) {
		this.name = name;
	}
	
	public void update() {
		setVoyageRepo(subject.getVoyageRepoUpdate());
		setReservationRepo(subject.getReservationRepoUpdate());
		
		System.out.println("Client mis à jour.");
	}
	
	public void setSubject(Database subject) {
		this.subject = subject;
		update();
	}
	
	public Database getSubjectReference() {
		return this.subject;
	}
	
	public VoyageRepository getVoyageRepo() {
		return voyageRepo;
	}
	public void setVoyageRepo(VoyageRepository voyageRepo) {
		this.voyageRepo = voyageRepo;
	}
	
	public ReservationRepository getReservationRepo() {
		return reservationRepo;
	}
	public void setReservationRepo(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

}