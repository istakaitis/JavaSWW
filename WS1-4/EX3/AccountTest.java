import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
class AccountTest {

	private MusicTitle musicTitle1, musicTitle2, musicTitle3;
	private AccountStandard accountJames;
	private AccountAdministrator admin;

	@BeforeEach
	public void init() {
		musicTitle1 = new MusicTitle("Thriller", "Michael Jackson", 15);
		musicTitle2 = new MusicTitle("Back in Black", "AC/DC", 18);
		musicTitle3 = new MusicTitle("Astro Lounge", "Smash Mouth", 20);

		accountJames = new AccountStandard("James", "Dr", "dr.james@mail.com", "password123");
		admin = new AccountAdministrator("Jim", "Mr", "admin@admin.com", "admin");
	}

	@Test
	public void testMusicTitle() {
		String expectedTitle = "Thriller";
		String actualTitle = musicTitle1.getTitle();
		assertEquals(expectedTitle, actualTitle, "Expected title does not match actual title");

		String expectedArtist = "Michael Jackson";
		String actualArtist = musicTitle1.getArtist();
		assertEquals(expectedArtist, actualArtist, "Expected artist does not match actual artist");

		int expectedPrice = 15;
		int actualPrice = musicTitle1.getPrice();
		assertEquals(expectedPrice, actualPrice, "Expected price does not match actual price");
	}

	@Test
	public void testAccountStandardGetters() {
		String expectedName = "James";
		String actualName = accountJames.getName();
		assertEquals(expectedName, actualName, "Expected name does not match actual name");

		String expectedSalutation = "Dr";
		String actualSalutation = accountJames.getSalutation();
		assertEquals(expectedSalutation, actualSalutation, "Expected salutation does not match actual salutation");

		String expectedEmail = "dr.james@mail.com";
		String actualEmail = accountJames.getEmail();
		assertEquals(expectedEmail, actualEmail, "Expected email does not match actual email");

		int expectedBalance = 0;
		int actualBalance = accountJames.getBalance();
		assertEquals(expectedBalance, actualBalance, "Expected balance does not match actual balance");
	}

	@Test
	public void testGetTitlesBought() {
		accountJames.login("password123");
		accountJames.deposit(100);
		accountJames.buy(musicTitle1);
		accountJames.buy(musicTitle2);
		accountJames.buy(musicTitle3);

		String expectedTitlesBought = "Thriller by Michael Jackson (£15)\n" + "Back in Black by AC/DC (£18)\n"
				+ "Astro Lounge by Smash Mouth (£20)\n";
		String actualTitlesBought = "";
		for (int i = 0; i < accountJames.getTitlesBought().size(); i++) {
			actualTitlesBought += accountJames.getTitlesBought().get(i).toString() + "\n";
		}
		assertEquals(expectedTitlesBought, actualTitlesBought,
				"Expected titles bought do not match actual titles bought");
	}

	@Test
	public void testToStringAccountStandard() {
		accountJames.login("password123");
		accountJames.deposit(100);
		accountJames.buy(musicTitle1);
		accountJames.buy(musicTitle2);
		accountJames.buy(musicTitle3);

		String expectedToString = "The account belongs to Dr James.\n" + "The email address is: dr.james@mail.com\n"
				+ "The password is: password123\n" + "Balance: 47\n"
				+ "Titles bought: [Thriller by Michael Jackson (£15), Back in Black by AC/DC (£18),"
				+ " Astro Lounge by Smash Mouth (£20)]";
		String actualToString = accountJames.toString();
		assertEquals(expectedToString, actualToString, "Expected toString does not match actual toString");
	}

	@Test
	public void testAccountAdministratorGetters() {
		String expectedName = "Jim";
		String actualName = admin.getName();
		assertEquals(expectedName, actualName, "Expected name does not match actual name");

		String expectedSalutation = "Mr";
		String actualSalutation = admin.getSalutation();
		assertEquals(expectedSalutation, actualSalutation, "Expected salutation does not match actual salutation");

		String expectedEmail = "admin@admin.com";
		String actualEmail = admin.getEmail();
		assertEquals(expectedEmail, actualEmail, "Expected email does not match actual email");
	}

	@Test
	public void testAccountAdministratorToString() {
		admin.login("admin");
		admin.addAccount(accountJames);
		accountJames.login("password123");
		String expectedToString = "The account belongs to Mr Jim.\n" + 
				"The email address is: admin@admin.com\n" + 
				"The password is: admin";
		String actualToString = admin.toString();
		assertEquals(expectedToString, actualToString, "Expected toString does not match actual toString");
	}

}
