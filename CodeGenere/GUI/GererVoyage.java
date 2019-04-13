package GUI;

import Repositories.*;

public class GererVoyage implements Command {

	Database receiver;

	public GererVoyage(Database receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.gererVoyageDB();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}