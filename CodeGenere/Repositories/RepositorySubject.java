package Repositories;

import GUI.*;

public abstract class RepositorySubject {

	/**
	 * 
	 * @param obs
	 */
	public void attach(RepositoryObserver obs) {

	}

	/**
	 * 
	 * @param obs
	 */
	public void detach(RepositoryObserver obs) {

	}

	public void notify() {
		// TODO - implement RepositorySubject.notify
		throw new UnsupportedOperationException();
	}

}