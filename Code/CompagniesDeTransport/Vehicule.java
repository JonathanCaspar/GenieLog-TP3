package CompagniesDeTransport;

import java.util.*;

import CompagniesDeTransport.Sections.*;

public abstract class Vehicule {

	private int id;
	protected ArrayList<Section> sections;
	public Vehicule() {
		sections = new ArrayList<Section>();
	}
	
	public abstract String getVehiculeType();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Section> getSections() {
		return sections;
	}
	
	public int acceptSiegeNb(Scanner userInput) {
		boolean toTheNextStep = true;
		int selection = 0;
		while(toTheNextStep) {
			try {
				selection = Integer.parseInt(userInput.next());
				toTheNextStep = false;
			}
			catch(NumberFormatException e){
				System.out.println("Nombre non valide. Veuillez reessayer:\n");
			}
		}
		return selection;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}
	
	public abstract void addSections(Scanner userInput); 
}