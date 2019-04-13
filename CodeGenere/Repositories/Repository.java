package Repositories;

import java.util.*;

public abstract class Repository implements IRepository {

	private Repository instance;
	Scanner userInput;
	protected Repository(Scanner userInput) {
		this.userInput = userInput;
	}

	public Repository getInstance() {
		return this.instance;
	}

}