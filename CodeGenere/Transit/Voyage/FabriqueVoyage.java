package Transit.Voyage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public abstract class FabriqueVoyage {

	Scanner userInput;
	public FabriqueVoyage(Scanner userInput){
		this.userInput = userInput;
	}
	
	protected abstract Voyage fabricateUnit();
	
	public Voyage createVoyage() {
		return fabricateUnit();
	}

}