package GUI;

import Repositories.*;

public class GererLieu implements Command {

	Database receiver;

	public GererLieu(Database receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.gererLieuDB();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}