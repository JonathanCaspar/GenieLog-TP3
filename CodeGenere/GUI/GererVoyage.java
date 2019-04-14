package GUI;

import Repositories.*;

public class GererVoyage implements Command {

	Database receiver;
	AdminDBObserver db;

	public GererVoyage(Database receiver, AdminDBObserver db) {
		this.receiver = receiver;
		this.db = db;
	}

	@Override
	public void execute() {
		receiver.gererVoyageDB(db);
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}