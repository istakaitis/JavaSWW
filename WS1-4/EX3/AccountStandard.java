import java.util.ArrayList;

/**
 * A standard account is an account for customers who can download music from
 * the music web site. They are represented by 3 field variables: balance,
 * titlesBought, and failedLoginAttempts of types int, ArrayList of type
 * MusicTitle, and int respectively. Only three login attempts are possible. If
 * the password is entered 3 times incorrectly, the account is disabled and only
 * an administrator can reinstate it.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
public class AccountStandard extends Account implements AccountStandardInterface {

	private int balance;
	private ArrayList<MusicTitle> titlesBought;
	private int failedLoginAttempts;
	public static final int MAXIMAL_LOGIN_ATTEMPTS = 3;

	/**
	 * Constructor for the AccountStandard class. It initialises titlesBought,
	 * balance to 0, and failedLoginAttempts to 0.
	 * 
	 * @param name       The name of the user of the account.
	 * @param salutation The salutation of the account holder.
	 * @param email      The email address of the account holder.
	 * @param password   The password of the account.
	 */
	public AccountStandard(String name, String salutation, String email, String password) {
		super(name, salutation, email, password);
		this.balance = 0;
		this.titlesBought = new ArrayList<MusicTitle>();
		this.failedLoginAttempts = 0;
	}

	/**
	 * Method for a user to log in to their account by providing a password. It is
	 * first checked whether the account is still active (that is, not too many
	 * failed login attempts were made in the past) and secondly whether the
	 * password provided is correct. In case of a correct login the number of login
	 * attempts is reset to 0, else increased by 1.
	 * 
	 * @param password The password provided for the login; this is to be compared
	 *                 to the password stored on the system.
	 */
	@Override
	public void login(String password) {
		if (this.getFailedLoginAttempts() < MAXIMAL_LOGIN_ATTEMPTS) {
			if (password.equals(this.getPassword())) {
				this.setLoggedIn(true);
				this.setFailedLoginAttempts(0);
			} else {
				System.out.println("Incorrect password");
				this.failedLoginAttempts++;
			}
		}
	}

	/**
	 * Getter method to return the balance.
	 * 
	 * @return The balance of the account.
	 */
	@Override
	public int getBalance() {
		return this.balance;
	}

	/**
	 * Getter method to return the list of all titles bought by the user.
	 * 
	 * @return The current list of titles bought by the user.
	 */
	@Override
	public ArrayList<MusicTitle> getTitlesBought() {
		return this.titlesBought;
	}

	/**
	 * Adds the amount - if positive - to the current balance. For non-positive
	 * amounts the action does nothing.
	 * 
	 * @param amount The amount being deposited.
	 */
	@Override
	public void deposit(int amount) {
		if (amount > 0) {
			this.balance += amount;
		}

	}

	/**
	 * Setter for the balance.
	 * 
	 * @param balance The new balance of the account.
	 */
	@Override
	public void setBalance(int balance) {
		this.balance = balance;

	}

	/**
	 * Getter method to return the number of failed login attempts.
	 * 
	 * @return The number of failed login attempts.
	 */
	@Override
	public int getFailedLoginAttempts() {
		return this.failedLoginAttempts;
	}

	/**
	 * Setter for the failed login attempts.
	 * 
	 * @param failedLoginAttempts The new number of failed login attempts.
	 */
	@Override
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
		// TODO Auto-generated method stub
	}

	/**
	 * If the user is logged in and has sufficient funds, a music title is bought by
	 * adding the title to the ArrayList of titlesBought of the customer.
	 * Furthermore the price of the title is subtracted from the funds of the
	 * customer. If the user is not logged in, a corresponding warning is to be
	 * printed. Likewise if the user has insufficient funds, they should be asked to
	 * pay money into their account.
	 * 
	 * @param musicTitle The music title that the customer wants to buy.
	 */
	@Override
	public void buy(MusicTitle musicTitle) {
		if (this.getLoggedIn() == true) {
			if (musicTitle.getPrice() <= this.balance) {
				this.titlesBought.add(musicTitle);
				this.balance -= musicTitle.getPrice();
			} else {
				System.out.println("Insufficient funds, please add money to the account");
			}
		} else {
			System.out.println("User not logged in");
		}
	}

	/**
	 * Standard toString method to represent the object in a human readable form. If
	 * the user is not logged in, only a warning should be printed, but no
	 * substantial information be given.
	 * 
	 * @return The object in a human readable form.
	 */
	@Override
	public String toString() {
		if (this.getLoggedIn() == false) {
			return "User is not logged in.";
		}
		return super.toString() + "\nBalance: " + this.getBalance() + "\nTitles bought: " + this.getTitlesBought().toString();
	}
}
