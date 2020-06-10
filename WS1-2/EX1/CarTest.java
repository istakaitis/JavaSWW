import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * The class CarTest contains 14 tests to test the setters, getters and toString
 * method in the class Car
 * 
 * @author Ignas Stakaitis
 * @version 19/10/2019
 *
 */
class CarTest {

	private Car car1;
	private Car car2;

	@BeforeEach
	public void beforeEach() {
		// Car(String make, int price, int maxSpeed, String colour)
		car1 = new Car("Tesla", 90000, 260, "black");
		// car2 object shows the limitations of the Car class, as it will accept any
		// String or int
		car2 = new Car("Potato", -1000, 0, "hello");
	}

	// testing getters
	@Test
	public void testGetMake1() {
		String expectedMake = "Tesla";
		String actualMake = car1.getMake();
		
		assertEquals(expectedMake, actualMake,
				"failure in testGetMake1: " + " expected make does not equal actual make");
	}

	@Test
	public void testGetMake2() {
		String expectedMake = "Potato";
		String actualMake = car2.getMake();
		
		assertEquals(expectedMake, actualMake,
				"failure in testGetMake2: " + " expected make does not equal actual make");
	}

	@Test
	public void testGetPrice1() {
		int expectedPrice = 90000;
		int actualPrice = car1.getPrice();
		
		assertEquals(expectedPrice, actualPrice,
				"failure in testGetPrice1: " + " expected price does not equal actual price");
	}

	@Test
	public void testGetPrice2() {
		int expectedPrice = -1000;
		int actualPrice = car2.getPrice();
		
		assertEquals(expectedPrice, actualPrice,
				"failure in testGetPrice2: " + " expected price does not equal actual price");
	}

	@Test
	public void testGetMaxSpeed1() {
		int expectedMaxSpeed = 260;
		int actualMaxSpeed = car1.getMaxSpeed();
		
		assertEquals(expectedMaxSpeed, actualMaxSpeed,
				"failure in testGetMaxSpeed1: " + " expected maximum speed does not equal actual maximum speed");
	}

	@Test
	public void testGetMaxSpeed2() {
		int expectedMaxSpeed = 0;
		int actualMaxSpeed = car2.getMaxSpeed();
		
		assertEquals(expectedMaxSpeed, actualMaxSpeed,
				"failure in testGetMaxSpeed2: " + " expected maximum speed does not equal actual maximum speed");
	}

	@Test
	public void testGetColour1() {
		String expectedColour = "black";
		String actualColour = car1.getColour();
		
		assertEquals(expectedColour, actualColour,
				"failure in testGetColour1: " + " expected colour does not equal actual colour");
	}

	@Test
	public void testGetColour2() {
		String expectedColour = "hello";
		String actualColour = car2.getColour();
		
		assertEquals(expectedColour, actualColour,
				"failure in testGetColour2: " + " expected colour does not equal actual colour");
	}

	// testing setters
	@Test
	public void testSetMake1() {
		car1.setMake("Lamborghini");
		String expectedMake = "Lamborghini";
		String actualMake = car1.getMake();

		assertEquals(expectedMake, actualMake,
				"failure in testSetMake1: " + " expected make does not equal actual make");
	}

	@Test
	public void testSetPrice1() {
		car2.setPrice(1000);
		int expectedPrice = 1000;
		int actualPrice = car2.getPrice();

		assertEquals(expectedPrice, actualPrice,
				"failure in testSetPrice1: " + " expected price does not equal actual price");
	}

	@Test
	public void testSetMaxSpeed1() {
		car1.setMaxSpeed(100);
		int expectedMaxSpeed = 100;
		int actualMaxSpeed = car1.getMaxSpeed();

		assertEquals(expectedMaxSpeed, actualMaxSpeed,
				"failure in testSetMaxSpeed1: " + " expected maximum speed does not equal actual maximum speed");
	}

	@Test
	public void testSetColour1() {
		car2.setColour("purple");
		String expectedColour = "purple";
		String actualColour = car2.getColour();

		assertEquals(expectedColour, actualColour,
				"failure in testSetColour1: " + " expected colour does not equal actual colour");
	}

	// testing toString
	@Test
	public void testToString1() {
		String expectedOutput = "The car is a black Tesla with a maximum speed of 260 kilometres per hour."
				+ " It is currently being sold for £90000.";
		String actualOutput = car1.toString();

		assertEquals(expectedOutput, actualOutput,
				"failure in testToString1: " + "expected toString output does not match actual toString output");
	}

	@Test
	public void testToString2() {
		String expectedOutput = "The car is a hello Potato with a maximum speed of 0 kilometres per hour."
				+ " It is currently being sold for £-1000.";
		String actualOutput = car2.toString();

		assertEquals(expectedOutput, actualOutput,
				"failure in testToString2: " + "expected toString output does not match actual toString output");
	}

}
