package Transit.Voyage;

import java.util.*;
import Transit.Lieux.*;
import Visitor.VoyageVisitor;

public class Croisiere extends Voyage {

	Port portDA;
	List<Port> portsIntermediaires = new ArrayList<Port>();
	
	@Override
	public void accept(VoyageVisitor visitor) {
		visitor.visit(this);
	}
	
	public void setPortDA(Port port) {
		this.portDA = port;
	}
	
	public void addPortInt(Port port) {
		portsIntermediaires.add(port);
	}
	
	public void printPortInt() {
		for(Lieu lieu : this.portsIntermediaires) {
			System.out.println("Sigle: " + lieu.getSigle() + " | Pays: " + lieu.getPays() + " | Ville: " + lieu.getVille());
		}
	}

}