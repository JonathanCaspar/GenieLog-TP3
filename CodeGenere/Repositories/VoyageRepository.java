package Repositories;

import java.util.*;
import Visitor.*;
import Transit.Voyage.*;

public class VoyageRepository extends Repository {

	protected VoyageRepository(Scanner userInput) {
		super(userInput);
	}

	Collection<Voyage> voyages;
	FabriqueVoyage fabVoy;

	/**
	 * 
	 * @param fabVoy
	 */
	public void creer(FabriqueVoyage fabVoy) {

	}

	public boolean gererVoyage() {
		// TODO - implement VoyageRepository.gererVoyage
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param visitor
	 */
	public void getSummary(VoyageVisitor visitor) {
		// TODO - implement VoyageRepository.getSummary
		throw new UnsupportedOperationException();
	}

	@Override
	public void creer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer() {
		// TODO Auto-generated method stub
		
	}

}