import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * The class FilmTest contains 5 tests for the getters, the setter and the
 * toString method in the class Film.
 * 
 * @author Ignas Stakaitis
 * @version 20/10/2019
 */
class FilmTest {

	private Date date;
	private Film film;

	@BeforeEach
	public void BeforeEach() {
		date = new Date(23, "September", 2011);
		film = new Film("Drive", date, 100);
	}

	// testing getters
	@Test
	public void testGetTitle() {
		String expectedTitle = "Drive";
		String actualTitle = film.getTitle();

		assertEquals(expectedTitle, actualTitle,
				"failure in testGetTitle: " + " expected title does not equal the actual title");
	}

	@Test
	public void testGetReleaseDate() {
		String expectedReleaseDate = "23 September 2011";
		String actualReleaseDate = film.getReleaseDate().toString();

		assertEquals(expectedReleaseDate, actualReleaseDate,
				"failure in testGetReleaseDate: " + " expected release date does not equal the actual release date");
	}

	@Test
	public void testGetLength() {
		int expectedLength = 100;
		int actualLength = film.getLength();

		assertEquals(expectedLength, actualLength,
				"failure in testGetLength: " + " expected length does not equal the actual length");
	}

	// testing setter setReleaseDate
	@Test
	public void testSetReleaseDate() {
		film.setReleaseDate(new Date(28, "February", 2018));
		String expectedReleaseDate = "28 February 2018";
		String actualReleaseDate = film.getReleaseDate().toString();

		assertEquals(expectedReleaseDate, actualReleaseDate,
				"failure in testSetReleaseDate: " + " expected release date does not equal the actual release date");
	}

	// testing toString
	@Test
	public void testToString() {
		String expectedOutput = "The film Drive was released on 23 September 2011 and is 1 h 40 min long.";
		String actualOutput = film.toString();

		assertEquals(expectedOutput, actualOutput,
				"failure in testToString: " + "expected toString output does not match actual toString output");
	}
}
