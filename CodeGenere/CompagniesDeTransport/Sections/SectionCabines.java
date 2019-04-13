package CompagniesDeTransport.Sections;

public abstract class SectionCabines implements Section {

	private Integer capacit�;
	private Integer nbCabines;
	protected float pourcentagePrix;
	
	public SectionCabines() {
		setNbCabines(1);
		setCapacit�(1);
	}
	public Integer getCapacit�() {
		return capacit�;
	}
	public void setCapacit�(Integer capacit�) {
		this.capacit� = capacit�;
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