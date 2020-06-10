import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * The class GoodTest contains 8 tests for the getters, setters, grossPrice
 * method, discount method and toString method in the class Good.
 * 
 * @author Ignas Stakaitis
 * @version 20/10/2019
 */
class GoodTest {

	private Good beef;
	private Good butter;
	public final static double TOLERANCE = 0.000001;

	@BeforeEach
	public void beforeEach() {
		beef = new Good("Mince beef", 4.00);
		butter = new Good("Butter", 1.00);
	}

	// testing getters
	@Test
	public void testGetters1() {
		String expectedName = "Mince beef";
		double expectedNetPrice = 4.00;
		String actualName = beef.getName();
		double actualNetPrice = beef.getNetPrice();

		assertEquals(expectedName, actualName,
				"failure in testGetters1: " + " expected name does not match actual name");
		assertEquals(expectedNetPrice, actualNetPrice, TOLERANCE,
				"failure in testGetters1: " + " expected net price is not approximately equal to actual net price");
	}

	@Test
	public void testGetters2() {
		String expectedName = "Butter";
		double expectedNetPrice = 1.00;
		String actualName = butter.getName();
		double actualNetPrice = butter.getNetPrice();

		assertEquals(expectedName, actualName,
				"failure in testGetters2: " + " expected name does not match actual name");
		assertEquals(expectedNetPrice, actualNetPrice, TOLERANCE,
				"failure in testGetters2: " + " expected net price is not approximately equal to actual net price");
	}

	// testing setters
	@Test
	public void testSetters1() {
		beef.setName("Burger");
		beef.setNetPrice(2.00);
		String expectedName = "Burger";
		double expectedNetPrice = 2.00;
		String actualName = beef.getName();
		double actualNetPrice = beef.getNetPrice();

		assertEquals(expectedName, actualName,
				"failure in testSetters1: " + " expected name does not match actual name");
		assertEquals(expectedNetPrice, actualNetPrice, TOLERANCE,
				"failure in testSetters1: " + " expected net price is not approximately equal to actual net price");
	}

	@Test
	public void testSetters2() {
		butter.setName("Salted butter");
		butter.setNetPrice(1.10);
		String expectedName = "Salted butter";
		double expectedNetPrice = 1.10;
		String actualName = butter.getName();
		double actualNetPrice = butter.getNetPrice();

		assertEquals(expectedName, actualName,
				"failure in testSetters2: " + " expected name does not match actual name");
		assertEquals(expectedNetPrice, actualNetPrice, TOLERANCE,
				"failure in testSetters2: " + " expected net price is not approximately equal to actual net price");
	}

	// testing grossPrice method and VATRate
	@Test
	public void testGrossPrice1() {
		double expectedGrossPrice = 4.80;
		double expectedVATRate = 20;
		double actualGrossPrice = beef.grossPrice();
		double actualVATRate = Good.VAT_RATE;

		assertEquals(expectedGrossPrice, actualGrossPrice, TOLERANCE, "failure in testGrossPrice1: "
				+ " expected gross price is not approximately equal to actual gross price");
		assertEquals(expectedVATRate, actualVATRate,
				"failure in testGrossPrice1: " + " expected VAT rate does not match actual VAT rate");
	}

	@Test
	public void testGrossPrice2() {
		double expectedGrossPrice = 1.2;
		double expectedVATRate = 20;
		double actualGrossPrice = butter.grossPrice();
		double actualVATRate = Good.VAT_RATE;

		assertEquals(expectedGrossPrice, actualGrossPrice, TOLERANCE, "failure in testGrossPrice2: "
				+ " expected gross price is not approximately equal to actual gross price");
		assertEquals(expectedVATRate, actualVATRate,
				"failure in testGrossPrice2: " + " expected VAT rate does not match actual VAT rate");
	}

	// testing discount method and toString
	@Test
	public void testDiscount1() {
		beef.discount(0);
		String expectedOutput = "The Mince beef has a gross price of \u00A34.80.";
		String actualOutput = beef.toString();

		assertEquals(expectedOutput, actualOutput,
				"failure in testDiscount1: " + "expected toString output does not match actual toString output");
	}

	@Test
	public void testDiscount2() {
		butter.discount(100);
		String expectedOutput = "The Butter has a gross price of \u00A30.00.";
		String actualOutput = butter.toString();

		assertEquals(expectedOutput, actualOutput,
				"failure in testDiscount2: " + "expected toString output does not match actual toString output");
	}
}
