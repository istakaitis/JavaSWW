/**
 * The class is used to represent music titles in form of a title, an artist,
 * and a price, of types String, String and int respectively.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
public class MusicTitle implements MusicTitleInterface {

	private String title;
	private String artist;
	private int price;

	/**
	 * The constructor for the MusicTitle class.
	 * 
	 * @param title  The title of the music title.
	 * @param artist The artist of the music title.
	 * @param price  The price of the music title.
	 */
	public MusicTitle(String title, String artist, int price) {
		this.title = title;
		this.artist = artist;
		this.price = price;
	}

	/**
	 * Standard getter for the title.
	 * 
	 * @return The title of the music title.
	 */
	@Override
	public String getTitle() {
		return this.title;
	}

	/**
	 * Standard getter for the artist.
	 * 
	 * @return The artist of the music title.
	 */
	@Override
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Standard getter for the price.
	 * 
	 * @return The price of the music title.
	 */
	@Override
	public int getPrice() {
		return this.price;
	}

	/**
	 * Standard toString method to represent the object in a human readable form.
	 * 
	 * @return The object in a human readable form.
	 */
	public String toString() {
		return this.getTitle() + " by " + this.getArtist() + " (\u00A3" + this.getPrice() + ")";
	}
}
