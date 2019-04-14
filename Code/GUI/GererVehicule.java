package GUI;

import Repositories.*;

public class GererVehicule implements Command {

	Database receiver;

	public GererVehicule(Database receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.gererVehiculeDB();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}