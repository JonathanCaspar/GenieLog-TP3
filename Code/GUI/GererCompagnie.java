package GUI;

import Repositories.*;

public class GererCompagnie implements Command {

	Database receiver;

	public GererCompagnie(Database receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.gererCompagnieDB();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}