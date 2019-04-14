package Transit.Lieux;

import java.util.*;

public abstract class FabriqueLieu {
	
	Scanner userInput;
	public FabriqueLieu(Scanner userInput){
		this.userInput = userInput;
	}

	protected abstract Lieu fabricateUnit();

	public Lieu createLieu() {
		Lieu newlieu = fabricateUnit();
		System.out.println("Entrer un sigle:\n");
		newlieu.setSigle(userInput.next());
		System.out.println("Entrer un pays:\n");
		newlieu.setPays(userInput.next());
		System.out.println("Entrer une ville:\n");
		newlieu.setVille(userInput.next());
		return newlieu;
	}

}