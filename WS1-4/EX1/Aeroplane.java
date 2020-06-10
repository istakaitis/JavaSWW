/**
 * The class Aeroplane is a subclass of Aircraft, which includes the fuel
 * consumption for the aeroplane as a double.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 *
 */
public class Aeroplane extends Aircraft {

	private double fuelConsumption;

	/**
	 * The constructor for the Aeroplane class.
	 * 
	 * @param passengerNumber The number of passengers on the aeroplane
	 * @param maxSpeed        The maximum speed of the aeroplane
	 * @param fuelConsumption The fuel consumption of the aeroplane
	 */
	public Aeroplane(int passengerNumber, int maxSpeed, double fuelConsumption) {
		super(passengerNumber, maxSpeed);
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * A standard getter for the fuel consumption.
	 * 
	 * @return the fuel consumption of the aeroplane
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * A standard setter for the fuel consumption.
	 * 
	 * @param fuelConsumption the fuel consumption to set
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * Standard toString method to represent the object in a human readable form.
	 */
	public String toString() {
		return super.toString() + "\nMaximum fuel consumption: " + this.getFuelConsumption() + " L/km";
	}

}
