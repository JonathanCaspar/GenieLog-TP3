package Transit.Voyage;

import Transit.Lieux.*;

public abstract class Voyage {

	private Text id;
	private Lieu lieuDepart;
	private DateTime dateDepart;
	private DateTime heureDepart;
	private Lieu lieuArrivee;
	private DateTime dateArrivee;
	private DateTime heureArrivee;
	private Money prix;

}