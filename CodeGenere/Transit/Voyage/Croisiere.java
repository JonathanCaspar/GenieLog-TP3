package Transit.Voyage;

import java.util.*;
import Transit.Lieux.*;
import Visitor.VoyageVisitor;

public class Croisiere extends Voyage {

	Collection<Port> portCroisiere;
	private Port[] portsIntermediaires;
	
	@Override
	public String accept(VoyageVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}