package CompagniesDeTransport.Sections;

import ReservationsClient.*;

public abstract class Habitat {

	private HabitatState currentState;
	private HabitatState available;
	private HabitatState reserved;
	private HabitatState confirmed;
	private float prix;

	/**
	 * 
	 * @param HabitatState
	 */
	public void setHabitatState(HabitatState habitatState) {
		this.currentState = habitatState;
	}

	public HabitatState getAvailableState() {
		return this.available;
	}

	public HabitatState getReservedState() {
		return this.reserved;
	}

	public HabitatState getConfirmedState() {
		return this.confirmed;
	}
	
	public float getPrix() {
		return prix;
	}

	public void reserver() {
		this.currentState.reserver(this);
	}

}