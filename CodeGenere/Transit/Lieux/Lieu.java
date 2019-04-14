package Transit.Lieux;

public abstract class Lieu {

	private String sigle;
	private String pays;
	private String ville;
	protected String lieuType;
	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getLieuType() {
		return lieuType;
	}
	
	

}