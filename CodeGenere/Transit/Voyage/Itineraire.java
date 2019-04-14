package Transit.Voyage;

import java.util.*;
import Transit.Lieux.*;
import Visitor.VoyageVisitor;

public class Itineraire extends Voyage {

	Gare gareD;
	List<Gare> garesIntermediaires = new ArrayList<Gare>();
	
	
	@Override
	public void accept(VoyageVisitor visitor) {
		visitor.visit(this);
	}
	
	public void setGareD(Gare gare) {
		this.gareD = gare;
	}
	
	public void addGareInt(Gare gare) {
		garesIntermediaires.add(gare);
	}
	
	public void printGareInt() {
		for(Lieu lieu : this.garesIntermediaires) {
			System.out.println("Sigle: " + lieu.getSigle() + " | Pays: " + lieu.getPays() + " | Ville: " + lieu.getVille());
		}
	}

}