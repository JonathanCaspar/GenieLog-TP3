package Transit.Voyage;

import java.util.*;
import Transit.Lieux.*;
import Visitor.VoyageVisitor;

public class Itineraire extends Voyage {

	Collection<Gare> gareItineraire;
	private Gare[] garesIntermediaires;
	
	@Override
	public String accept(VoyageVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}