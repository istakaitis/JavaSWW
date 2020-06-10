import java.util.ArrayList;

/**
 * AccountAdminstrator is a sub-class of Account. An administrator can reset the
 * accounts of standard users (in case they have forgotten their password or
 * have attempted to login unsuccessfully to often). An administrator can have
 * arbitrarily many unsuccessful login attempts.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
public class AccountAdministrator extends Account implements AccountAdministratorInterface {

	private ArrayList<Account> accounts;

	/**
	 * Constructor for AccountAdministrator. It initialises the accounts ArrayList
	 * of type Account.
	 * 
	 * @param name       The name of the user of the account.
	 * @param salutation The salutation of the account holder.
	 * @param email      The email address of the account holder.
	 * @param password   The password of the account.
	 */
	public AccountAdministrator(String name, String salutation, String email, String password) {
		super(name, salutation, email, password);
		this.accounts = new ArrayList<Account>();
	}

	/**
	 * Method for an administrator to log in by providing a password. It is checked
	 * whether the password provided is correct.
	 * 
	 * @param password The password provided for the login; this is to be compared
	 *                 to the password stored on the system.
	 */
	@Override
	public void login(String password) {
		if (password.equals(this.getPassword())) {
			this.setLoggedIn(true);
		} else {
			System.out.println("Incorrect password");
		}
	}

	/**
	 * Getter method to return the list of accounts the administrator looks after.
	 * 
	 * @return The list of accounts the administrator looks after.
	 */
	@Override
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	/**
	 * The method adds an account to the list of accounts the administrator looks
	 * after.
	 * 
	 * @param customer The new account to be added to the list of accounts the
	 *                 administrator looks after.
	 */
	@Override
	public void addAccount(Account account) {
		this.accounts.add(account);

	}

	/**
	 * If an account can no longer be used, since either the user has forgotten
	 * their password or in case of a standard user has entered the password
	 * incorrectly too often the administrator can reset the account by setting a
	 * new password and resetting the number of failed login attempts to zero (the
	 * latter only if the account is a standard account).
	 * 
	 * @param account  The account that is to be reset.
	 * @param password The new password for the account that is to be reset.
	 */
	@Override
	public void resetAccount(Account account, String password) {
		if (accounts.contains(account)) {
			account.setPassword(password);
			if (account instanceof AccountStandard) {
				((AccountStandard) account).setFailedLoginAttempts(0);
			}
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
		return super.toString();
	}

}
