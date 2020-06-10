import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class SubscriptionTest contains tests for the classes Subscription and
 * SubscriptionPrime.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
class SubscriptionTest {

	private SubscriptionInterface subInterface;
	private Subscription sub;
	private SubscriptionPrimeInterface subPrimeInterface;
	private SubscriptionPrime subPrime;

	@BeforeEach
	public void init() {
		subInterface = new Subscription("Birmingham Business Journal", "john@mail.com", 6);
		sub = new Subscription("Birmingham News", "jack@mail.com", 4);
		subPrimeInterface = new SubscriptionPrime("Nature", "jim@mail.com", 5, "100 Hagley Road");
		subPrime = new SubscriptionPrime("Science", "james@mail.com", 7, "5 Broad Street");
	}

	@Test
	public void testGettersSubscription() {
		String expectedTitle = "Birmingham Business Journal";
		String actualTitle = subInterface.getTitle();
		assertEquals(expectedTitle, actualTitle, "Expected title does not match actual title");

		String expectedEmail = "jack@mail.com";
		String actualEmail = sub.getEmail();
		assertEquals(expectedEmail, actualEmail, "Expected email does not match actual email");

		int expectedCost = 6;
		int actualCost = subInterface.getCost();
		assertEquals(expectedCost, actualCost, "Expected cost does not match actual cost");
	}

	@Test
	public void testGettersSubscriptionPrime() {
		String expectedTitle = "Science";
		String actualTitle = subPrime.getTitle();
		assertEquals(expectedTitle, actualTitle, "Expected title does not match actual title");

		String expectedEmail = "james@mail.com";
		String actualEmail = subPrime.getEmail();
		assertEquals(expectedEmail, actualEmail, "Expected email does not match actual email");

		int expectedCost = 7;
		int actualCost = subPrime.getCost();
		assertEquals(expectedCost, actualCost, "Expected cost does not match actual cost");
	}

	@Test
	public void testGetAddress() {
		String expectedDeliveryAddress1 = "100 Hagley Road";
		String actualDeliveryAddress1 = subPrimeInterface.getAddress();
		assertEquals(expectedDeliveryAddress1, actualDeliveryAddress1,
				"Expected delivery address does not match actual delivery address");

		String expectedDeliveryAddress2 = "5 Broad Street";
		String actualDeliveryAddress2 = subPrime.getAddress();
		assertEquals(expectedDeliveryAddress2, actualDeliveryAddress2,
				"Expected delivery address does not match actual delivery address");
	}

	@Test
	public void testToStringSubscription() {
		String expectedToString1 = "Journal title: Birmingham News\n" + "Email address: jack@mail.com\n"
				+ "Journal cost: £4 per month";
		String actualToString1 = sub.toString();
		assertEquals(expectedToString1, actualToString1, "Expected toString does not match actual toString");

		String expectedToString2 = "Journal title: Birmingham Business Journal\n" + "Email address: john@mail.com\n"
				+ "Journal cost: £6 per month";
		String actualToString2 = subInterface.toString();
		assertEquals(expectedToString2, actualToString2, "Expected toString does not match actual toString");
	}

	@Test
	public void testToStringSubscriptionPrime() {
		String expectedToString1 = "Journal title: Science\n" + "Email address: james@mail.com\n"
				+ "Journal cost: £7 per month\n" + "Delivery address: 5 Broad Street";
		String actualToString1 = subPrime.toString();
		assertEquals(expectedToString1, actualToString1, "Expected toString does not match actual toString");

		String expectedToString2 = "Journal title: Nature\n" + "Email address: jim@mail.com\n"
				+ "Journal cost: £5 per month\n" + "Delivery address: 100 Hagley Road";
		String actualToString2 = subPrimeInterface.toString();
		assertEquals(expectedToString2, actualToString2, "Expected toString does not match actual toString");
	}
}
