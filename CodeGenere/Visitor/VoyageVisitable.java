package Visitor;

public interface VoyageVisitable {

	/**
	 * 
	 * @param visitor
	 */
	String accept(VoyageVisitor visitor);

}