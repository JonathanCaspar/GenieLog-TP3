package GUI;

import Repositories.*;

public class AdminDBObserver extends RepositoryObserver {
	
	private VoyageRepository voyageRepo;
	private ReservationRepository reservationRepo;
	private VehiculeRepository vehiculeRepo;
	private LieuRepository lieuRepo;
	private ClientRepository clientRepo;
	private CompagnieRepository compagnieRepo;
	String updateTester = "message";
	
	Database subject;
	String name;
	public AdminDBObserver(String name) {
		this.name = name;
	}
	public void update() {
		setVoyageRepo(subject.getVoyageRepoUpdate());
		setReservationRepo(subject.getReservationRepoUpdate());
		setVehiculeRepo(subject.getVehiculeRepoUpdate());
		setLieuRepo(subject.getLieuRepoUpdate());
		setClientRepo(subject.getClientRepoUpdate());
		setCompagnieRepo(subject.getCompagnieRepoUpdate());
		updateTester = subject.getTestUpdate();
		
		System.out.println("Admin mis à jour.");
	}
	public void setSubject(Database subject) {
		this.subject = subject;
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
	public VehiculeRepository getVehiculeRepo() {
		return vehiculeRepo;
	}
	public void setVehiculeRepo(VehiculeRepository vehiculeRepo) {
		this.vehiculeRepo = vehiculeRepo;
	}
	public LieuRepository getLieuRepo() {
		return lieuRepo;
	}
	public void setLieuRepo(LieuRepository lieuRepo) {
		this.lieuRepo = lieuRepo;
	}
	public ClientRepository getClientRepo() {
		return clientRepo;
	}
	public void setClientRepo(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}
	public CompagnieRepository getCompagnieRepo() {
		return compagnieRepo;
	}
	public void setCompagnieRepo(CompagnieRepository compagnieRepo) {
		this.compagnieRepo = compagnieRepo;
	}
}