package GUI;

public class AdminInvoker {

	private Command command;

	/**
	 * 
	 * @param Command
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}

}