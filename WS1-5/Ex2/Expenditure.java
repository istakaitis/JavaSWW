/**
 * The class Expenditure hold the expenditures associated with a company. It is
 * used to create an objects which are used in making waffle or pie charts to
 * visually represent the expenditures.
 * 
 * @author Ignas Stakaitis
 * @version 01/12/2019
 */
public class Expenditure {
	/**
	 * A short description of the expenditure.
	 */
	private String description;
	/**
	 * The cost associated with the expenditure.
	 */
	private int value;

	/**
	 * The constructor for Expenditure. It takes as arguments the description and
	 * value of the expenditure, String and integer respectively.
	 * 
	 * @param description A short description of the expenditure.
	 * @param value       The cost associated with the expenditure.
	 */
	public Expenditure(String description, int value) {
		this.description = description;
		this.value = value;
	}

	/**
	 * A standard getter for the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * A standard getter for the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

}
