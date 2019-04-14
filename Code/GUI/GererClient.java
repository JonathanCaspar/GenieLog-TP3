package GUI;

import Repositories.*;

public class GererClient implements Command {

	Database receiver;

	public GererClient(Database receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.gererClientDB();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}