package Transit.Voyage;

import Visitor.*;

import java.time.*;
import java.util.*;

import Transit.Lieux.*;

public abstract class Voyage implements VoyageVisitable {

	private String id;
	private Lieu lieuDepart;
	private Date dateDepart;
	private Lieu lieuArrivee;
	private Date dateArrivee;
	private float prix;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Lieu getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(Lieu lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Lieu getLieuArrivee() {
		return lieuArrivee;
	}
	public void setLieuArrivee(Lieu lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

}