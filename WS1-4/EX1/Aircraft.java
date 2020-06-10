/**
 * The class Aircraft describes an aircraft with the passenger number and
 * maximum speed, both represented by integers.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
public class Aircraft {

	private int passengerNumber;
	private int maxSpeed;

	/**
	 * The constructor for the Aircraft class.
	 * 
	 * @param passengerNumber The number of passengers on the aircraft
	 * @param maxSpeed        The maximum speed of the aircraft
	 */
	public Aircraft(int passengerNumber, int maxSpeed) {
		this.passengerNumber = passengerNumber;
		this.maxSpeed = maxSpeed;
	}

	/**
	 * A standard getter for the passenger number.
	 * 
	 * @return the number of passengers
	 */
	public int getPassengerNumber() {
		return passengerNumber;
	}

	/**
	 * A standard getter for the maximum speed.
	 * 
	 * @return the maximum speed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * A standard setter for the passenger number.
	 * 
	 * @param passengerNumber the passenger number to set
	 */
	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	/**
	 * A standard setter for the maximum speed.
	 * 
	 * @param maxSpeed the maximum speed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * Standard toString method to represent the object in a human readable form.
	 */
	public String toString() {
		return "Number of passengers: " + this.getPassengerNumber() + "\nMaximum speed: " + this.getMaxSpeed()
				+ " km/h";
	}

}
