/**
 * Film is a class which displays the title, release date and runtime of a film
 * in the form of a sentence.
 * 
 * @author Ignas Stakaitis
 * @version 19/10/2019
 */
public class Film {
	private String title;
	private Date releaseDate;
	private int length;

	/**
	 * The constructor Film initialises the information about a film. This includes
	 * the title, release date and length of a film which are a String, a Date and
	 * an int respectively.
	 * 
	 * @param title       the name of the film
	 * @param releaseDate when the film was released
	 * @param length      the runtime of the film (in minutes)
	 */
	public Film(String title, Date releaseDate, int length) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.length = length;
	}

	/**
	 * getTitle is a getter method for the title of the film.
	 * 
	 * @return the title of the film
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * getReleaseDate is a getter method for the release date of the film.
	 * 
	 * @return the release date of the film
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * getLength is a getter method for the runtime of the film.
	 * 
	 * @return the runtime of the film
	 */
	public int getLength() {
		return length;
	}

	/**
	 * setReleaseDate is a setter method for the release date of the film
	 * 
	 * @param releaseDate the release date to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * The toString method provides readable information about the film.
	 * 
	 * @return prints basic information about the film (title, release date and
	 *         length)
	 */
	public String toString() {
		return "The film " + title + " was released on " + releaseDate + " and is " + length / 60 + " h "
				+ length % 60 + " min long.";
	}

	/**
	 * A main method that creates a Date object, a Film object, and calls the
	 * toString method.
	 */
	public static void main(String[] args) {
		Date adAstraRelease = new Date(18, "September", 2019);
		Film adAstra = new Film("Ad Astra", adAstraRelease, 123);
		System.out.println(adAstra);

	}

}
