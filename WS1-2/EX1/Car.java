/**
 * Car is a class which displays the make, price, maximum speed and colour of a
 * car in a couple of sentences.
 * 
 * @author Ignas Stakaitis
 * @version 19/10/2019
 */
public class Car {
	private String make;
	private int price;
	private int maxSpeed;
	private String colour;

	/**
	 * The constructor Car initialises the parameters associated with a car. This
	 * includes the make, the price, the maximum speed and the colour which are a
	 * String, an int, an int and a String respectively.
	 * 
	 * 
	 * @param make     the make of the car
	 * @param price    the price of the car
	 * @param maxSpeed the maximum speed of the car
	 * @param colour   the colour of the car
	 */
	public Car(String make, int price, int maxSpeed, String colour) {
		this.make = make;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.colour = colour;
	}

	/**
	 * getMake is a getter method for the make of the car.
	 * 
	 * @return the make of the car
	 */
	public String getMake() {
		return make;
	}

	/**
	 * getPrice is a getter method for the price of the car.
	 * 
	 * @return the price of the car
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * getMaxSpeed is a getter method for the maximum speed of the car.
	 * 
	 * @return the maximum speed of the car
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * getColour is a getter method for the colour of the car.
	 * 
	 * @return the colour of the car
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * setMake is a setter method for the make of the car.
	 * 
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * setPrice is a setter method for the price of the car.
	 * 
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * setMaxSpeed is a setter method for the maximum speed of the car.
	 * 
	 * @param maxSpeed the maximum speed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * setColour is a setter method for the colour of the car.
	 * 
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * This toString method provides a readable description of the car.
	 * 
	 * @return prints the description of the car in two sentences
	 */
	public String toString() {
		return "The car is a " + colour + " " + make + " with a maximum speed of " + maxSpeed
				+ " kilometres per hour. It is currently being sold for \u00A3" + price + ".";
	}

	/**
	 * A main method that creates a car object and calls the toString method to
	 * print out a description.
	 */
	public static void main(String[] args) {
		Car toyota = new Car("Toyota", 20000, 260, "blue");
		System.out.println(toyota);

	}

}
