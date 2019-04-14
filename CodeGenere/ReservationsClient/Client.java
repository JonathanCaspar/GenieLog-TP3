package ReservationsClient;

import java.util.Date;

public class Client {

	private Integer clientID;
	private String nom;
	private String prenom;
	private String courriel;
	private String telephone;
	private Date dateDeNaissance;
	private String numPasseport;
	private Date expirationPasseport;
	
	public Integer getClientID() {
		return clientID;
	}
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCourriel() {
		return courriel;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getNumPasseport() {
		return numPasseport;
	}
	public void setNumPasseport(String numPasseport) {
		this.numPasseport = numPasseport;
	}
	public Date getExpirationPasseport() {
		return expirationPasseport;
	}
	public void setExpirationPasseport(Date expirationPasseport) {
		this.expirationPasseport = expirationPasseport;
	}

}