/**
 * Good is a class which displays the good and its price gross price. The price
 * may be discounted with the discount method.
 * 
 * @author Ignas Stakaitis
 * @version 19/10/2019
 */
public class Good {
	private String name;
	private double netPrice;
	final static double VAT_RATE = 20;
	private double discount;

	/**
	 * The constructor Good initialises the name and net price of a good. These are
	 * a String and a double respectively. Discount is initially set to 0 as well.
	 * 
	 * @param name     the name of the good
	 * @param netPrice the net price of the good
	 */
	public Good(String name, double netPrice) {
		this.name = name;
		this.netPrice = netPrice;
		this.discount = 0;
	}

	/**
	 * getName is a getter method for the name of the good.
	 * 
	 * @return the name of a good
	 */
	public String getName() {
		return name;
	}

	/**
	 * getNetPrice is a getter method for the net price of a good.
	 * 
	 * @return the netPrice of a good
	 */
	public double getNetPrice() {
		return netPrice;
	}

	/**
	 * setName is a setter method for the name of a good.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * setNetPrice is a setter method for the net price of a good.
	 * 
	 * @param netPrice the netPrice to set
	 */
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	/**
	 * The grossPrice method calculates and returns the gross price by multiplying
	 * the net price by the VAT rate.
	 * 
	 * @return the gross price of a good
	 */
	public double grossPrice() {
		return this.getNetPrice() * (VAT_RATE / 100 + 1);
	}

	/**
	 * The method discount takes as an argument the discount rate and calculates the
	 * amount that has to be subtracted from the gross price to result in the
	 * discounted price. This amount is stored in the discount variable.
	 * 
	 * @param rate the discount rate
	 */
	public void discount(double rate) {
		this.discount = this.grossPrice() * rate / 100;
	}

	/**
	 * The toString method prints a sentence which names the good and its gross
	 * price to two decimal places. If a discount is set with the discount method,
	 * the variable discount is subtracted from the gross price.
	 * 
	 * @return prints the gross price of a good
	 */
	public String toString() {
		return "The " + name + " has a gross price of \u00A3"
				+ String.format("%.2f", (this.grossPrice() - this.discount)) + ".";
	}

	/**
	 * A main method that creates a Good object, applies a 20% discount and calls
	 * the toString method.
	 */
	public static void main(String[] args) {
		Good milk = new Good("Milk", 0.50);
		milk.discount(20);
		System.out.println(milk);

	}

}
