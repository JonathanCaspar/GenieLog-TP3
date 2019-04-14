package CompagniesDeTransport;

import java.util.*;

import Transit.Lieux.Lieu;

public abstract class FabriqueVehicule {

	Scanner userInput;
	public FabriqueVehicule(Scanner userInput){
		this.userInput = userInput;
	}
	protected abstract Vehicule fabricateUnit();

	public Vehicule createVehicule(int newId) {
		Vehicule newvehicule = fabricateUnit();
		newvehicule.setId(newId);
		return newvehicule;
	}

}