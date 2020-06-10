/**
 * The class describes a prime journal subscription. In addition to a standard
 * subscription, the customer receives a hardcopy of the journal. In order to
 * store the corresponding address, where the hardcopy is to be sent to, a field
 * variable address of type String is used.
 *
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
public class SubscriptionPrime extends Subscription implements SubscriptionPrimeInterface {

	private String address;

	/**
	 * @param title   The title of the journal.
	 * @param email   The email address to which the journal is to be sent.
	 * @param cost    The price in GBP the customer has to pay for one issue of the
	 *                journal.
	 * @param address The address to which the journal is to be sent.
	 */
	public SubscriptionPrime(String title, String email, int cost, String address) {
		super(title, email, cost);
		this.address = address;
	}

	/**
	 * A standard getter for the address.
	 * 
	 * @return The address to which the journal is to be sent.
	 */
	@Override
	public String getAddress() {
		return this.address;
	}

	/**
	 * Standard toString method to represent the object in a human readable form.
	 * 
	 * @return The object in a human readable form.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nDelivery address: " + this.getAddress();
	}

}
