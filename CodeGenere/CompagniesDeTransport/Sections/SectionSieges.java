package CompagniesDeTransport.Sections;

public abstract class SectionSieges implements Section {

	private Integer nbSieges;
	protected float pourcentagePrix;
	
	public SectionSieges() {
		setNbSieges(1);
	}
	
	public Integer getNbSieges() {
		return nbSieges;
	}
	public void setNbSieges(Integer nbSieges) {
		this.nbSieges = nbSieges;
	}
	public float getPourcentagePrix() {
		return pourcentagePrix;
	}
	public void setPourcentagePrix(int pourcentagePrix) {
		this.pourcentagePrix = pourcentagePrix;
	}

}