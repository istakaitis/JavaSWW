/**
 * The class describes a journal subscription using the title of the journal,
 * the email address to where the subscription is to be sent, and the cost in
 * pounds.
 *
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
public class Subscription implements SubscriptionInterface {

	private String title;
	private String email;
	private int cost;

	/**
	 * The constructor for the Subscription class.
	 * 
	 * @param title The title of the journal.
	 * @param email The email address to which the journal is to be sent.
	 * @param cost  The price in GBP the customer has to pay for one issue of the
	 *              journal.
	 */
	public Subscription(String title, String email, int cost) {
		this.title = title;
		this.email = email;
		this.cost = cost;
	}

	/**
	 * A standard getter for the title.
	 * 
	 * @return The title of the journal.
	 */
	@Override
	public String getTitle() {
		return this.title;
	}

	/**
	 * A standard getter for the email.
	 * 
	 * @return The email address to which the journal is to be sent.
	 */
	@Override
	public String getEmail() {
		return this.email;
	}

	/**
	 * A standard getter for the cost.
	 * 
	 * @return The price in GBP the customer has to pay for one issue of the
	 *         journal.
	 */
	@Override
	public int getCost() {
		return this.cost;
	}

	/**
	 * Standard toString method to represent the object in a human readable form.
	 * 
	 * @return The object in a human readable form.
	 */
	public String toString() {
		return "Journal title: " + this.getTitle() + "\nEmail address: " + this.getEmail() + "\nJournal cost: \u00A3"
				+ this.getCost() + " per month";
	}

}
