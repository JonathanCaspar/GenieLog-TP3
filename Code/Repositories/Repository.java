package Repositories;

public abstract class Repository extends RepositorySubject implements IRepository {

	private Repository instance;

	private Repository() {
		// TODO - implement Repository.Repository
		throw new UnsupportedOperationException();
	}

	public Repository getInstance() {
		return this.instance;
	}

}