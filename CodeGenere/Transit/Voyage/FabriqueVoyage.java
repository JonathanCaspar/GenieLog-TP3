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
		//To be used for userInput
		
		
		
		Voyage voy = fabricateUnit();
		System.out.println("Entrer un id:\n");
		voy.setId(userInput.next());
		
		/*
		System.out.println("Entrer un lieu de départ:\n");
		voy.setLieuDepart(userInput.next());
		System.out.println("Entrer un lieu d'arrivé:\n");
		voy.setLieuArrivee(userInput.next());
		*/
		
		boolean timeok = true;
		while(timeok) {
			try {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				//Date date = simpleDateFormat.parse("2018-09-09");
				
				System.out.println("Entrer une date de départ(AAAA-MM-JJ):\n");
				Date date = simpleDateFormat.parse(userInput.next());
				
				voy.setDateDepart(date);
				timeok = false;
				
			}catch(ParseException e) {
				System.out.println("Format invalide. Veuiller réessayer:");
			}
		}
		timeok = true;

		return voy;
	}

}