package Visitor;

public interface VoyageVisitable {

	/**
	 * 
	 * @param visitor
	 */
	string accept(VoyageVisitor visitor);

}