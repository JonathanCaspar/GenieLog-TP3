package CompagniesDeTransport.Sections;

public abstract class SectionCabines implements Section {

	private Integer capacite;
	private Integer nbCabines;
	protected float pourcentagePrix;
	
	public SectionCabines() {
		setNbCabines(1);
		setCapacite(1);
	}
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Integer getNbCabines() {
		return nbCabines;
	}
	public void setNbCabines(Integer nbCabines) {
		this.nbCabines = nbCabines;
	}
	public float getPourcentagePrix() {
		return pourcentagePrix;
	}
	public void setPourcentagePrix(int pourcentagePrix) {
		this.pourcentagePrix = pourcentagePrix;
	}

}