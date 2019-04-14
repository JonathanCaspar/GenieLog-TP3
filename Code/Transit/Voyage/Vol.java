package Transit.Voyage;

import Visitor.VoyageVisitor;

public class Vol extends Voyage {

	@Override
	public void accept(VoyageVisitor visitor) {
		visitor.visit(this);
	}
}