package Visitor;

import Transit.Voyage.*;

public interface VoyageVisitor {

	/**
	 * 
	 * @param vol
	 */
	void visit(Vol vol);

	/**
	 * 
	 * @param itineraire
	 */
	void visit(Itineraire itineraire);

	/**
	 * 
	 * @param croisiere
	 */
	void visit(Croisiere croisiere);

}