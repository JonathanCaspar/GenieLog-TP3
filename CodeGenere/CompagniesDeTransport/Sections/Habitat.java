package CompagniesDeTransport.Sections;

import ReservationsClient.*;

public abstract class Habitat {

	private HabitatState currentState;
	private HabitatState available;
	private HabitatState reserved;
	private HabitatState confirmed;
	private Money prix;

	/**
	 * 
	 * @param HabitatState
	 */
	public void setHabitatState(int HabitatState) {
		// TODO - implement Habitat.setHabitatState
		throw new UnsupportedOperationException();
	}

	public HabitatState getAvailableState() {
		// TODO - implement Habitat.getAvailableState
		throw new UnsupportedOperationException();
	}

	public HabitatState getReservedState() {
		// TODO - implement Habitat.getReservedState
		throw new UnsupportedOperationException();
	}

	public HabitatState getConfirmedState() {
		// TODO - implement Habitat.getConfirmedState
		throw new UnsupportedOperationException();
	}

	public void reserver() {
		// TODO - implement Habitat.reserver
		throw new UnsupportedOperationException();
	}

}