package CompagniesDeTransport.Sections;

public abstract class SectionCabines implements Section {

	private Integer capacité;
	private Integer nbCabines;
	protected float pourcentagePrix;
	
	public SectionCabines() {
		setNbCabines(1);
		setCapacité(1);
	}
	public Integer getCapacité() {
		return capacité;
	}
	public void setCapacité(Integer capacité) {
		this.capacité = capacité;
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