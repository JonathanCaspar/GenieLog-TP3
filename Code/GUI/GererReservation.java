package GUI;

import Repositories.*;

public class GererReservation implements Command {

	Database receiver;

	public GererReservation(Database receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.gererReservationDB();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}