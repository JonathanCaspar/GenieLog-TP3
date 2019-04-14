package Visitor;

public interface VoyageVisitable {

	/**
	 * 
	 * @param visitor
	 */
	void accept(VoyageVisitor visitor);

}