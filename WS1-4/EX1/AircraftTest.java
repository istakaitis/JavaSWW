import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * AircraftTest is a class which contains JUnit tests for the Aircraft and
 * Aeroplane classes.
 * 
 * @author Ignas Stakaitis
 * @version 16/11/2019
 */
class AircraftTest {

	public static final double TOLERANCE = 0.00000001;
	private Aircraft AH64, DG800;
	private Aeroplane boeing747, boeing787;

	@BeforeEach
	public void init() {

		AH64 = new Aircraft(2, 365);
		DG800 = new Aircraft(1, 270);
		boeing747 = new Aeroplane(660, 920, 12);
		boeing787 = new Aeroplane(440, 956, 10);

	}

	@Test
	public void testGettersAircraft() {
		int expectedPassengersAH64 = 2;
		int actualPassengersAH64 = AH64.getPassengerNumber();
		assertEquals(expectedPassengersAH64, actualPassengersAH64,
				"Expected passenger number does not match actual passenger number");

		int expectedMaxSpeedDG800 = 270;
		int actualMaxSpeedDG800 = DG800.getMaxSpeed();
		assertEquals(expectedMaxSpeedDG800, actualMaxSpeedDG800,
				"Expected maximum speed does not match actual maximum speed");
	}

	@Test
	public void testGettersAeroplane() {

		int expectedPassengersBoeing747 = 660;
		int actualPassengersBoeing747 = boeing747.getPassengerNumber();
		assertEquals(expectedPassengersBoeing747, actualPassengersBoeing747,
				"Expected passenger number does not match actual passenger number");

		int expectedMaxSpeedBoeing787 = 956;
		int actualMaxSpeedBoeing787 = boeing787.getMaxSpeed();
		assertEquals(expectedMaxSpeedBoeing787, actualMaxSpeedBoeing787,
				"Expected maximum speed does not match actual maximum speed");

		double expectedFuelBoeing747 = 12;
		double actualFuelBoeing747 = boeing747.getFuelConsumption();
		assertEquals(expectedFuelBoeing747, actualFuelBoeing747, TOLERANCE,
				"Expected fuel consumption does not match actual fuel consumption");

		double expectedFuelBoeing787 = 10;
		double actualFuelBoeing787 = boeing787.getFuelConsumption();
		assertEquals(expectedFuelBoeing787, actualFuelBoeing787, TOLERANCE,
				"Expected fuel consumption does not match actual fuel consumption");
	}

	@Test
	public void testSettersAircraft() {
		AH64.setPassengerNumber(10);
		int expectedPassengersAH64 = 10;
		int actualPassengersAH64 = AH64.getPassengerNumber();
		assertEquals(expectedPassengersAH64, actualPassengersAH64,
				"Expected passenger number does not match actual passenger number");

		DG800.setMaxSpeed(999);
		int expectedMaxSpeedDG800 = 999;
		int actualMaxSpeedDG800 = DG800.getMaxSpeed();
		assertEquals(expectedMaxSpeedDG800, actualMaxSpeedDG800,
				"Expected maximum speed does not match actual maximum speed");
	}

	@Test
	public void testSettersAeroplane() {
		boeing747.setPassengerNumber(1000);
		int expectedPassengersBoeing747 = 1000;
		int actualPassengersBoeing747 = boeing747.getPassengerNumber();
		assertEquals(expectedPassengersBoeing747, actualPassengersBoeing747,
				"Expected passenger number does not match actual passenger number");

		boeing787.setMaxSpeed(5);
		int expectedMaxSpeedBoeing787 = 5;
		int actualMaxSpeedBoeing787 = boeing787.getMaxSpeed();
		assertEquals(expectedMaxSpeedBoeing787, actualMaxSpeedBoeing787,
				"Expected maximum speed does not match actual maximum speed");

		boeing747.setFuelConsumption(0);
		double expectedFuelBoeing747 = 0;
		double actualFuelBoeing747 = boeing747.getFuelConsumption();
		assertEquals(expectedFuelBoeing747, actualFuelBoeing747, TOLERANCE,
				"Expected fuel consumption does not match actual fuel consumption");

		boeing787.setFuelConsumption(100);
		double expectedFuelBoeing787 = 100;
		double actualFuelBoeing787 = boeing787.getFuelConsumption();
		assertEquals(expectedFuelBoeing787, actualFuelBoeing787, TOLERANCE,
				"Expected fuel consumption does not match actual fuel consumption");
	}

	@Test
	public void testToStringAircraft() {
		String expectedToStringAH64 = "Number of passengers: 2\n" + "Maximum speed: 365 km/h";
		String actualToStringAH64 = AH64.toString();
		assertEquals(expectedToStringAH64, actualToStringAH64, "Expected toString does not match actual toString");

		String expectedToStringDG800 = "Number of passengers: 1\n" + "Maximum speed: 270 km/h";
		String actualToStringDG800 = DG800.toString();
		assertEquals(expectedToStringDG800, actualToStringDG800, "Expected toString does not match actual toString");
	}

	@Test
	public void testToStringAeroplane() {
		String expectedToStringBoeing747 = "Number of passengers: 660\n" + "Maximum speed: 920 km/h\n"
				+ "Maximum fuel consumption: 12.0 L/km";
		String actualToStringBoeing747 = boeing747.toString();
		assertEquals(expectedToStringBoeing747, actualToStringBoeing747,
				"Expected toString does not match actual toString");

		String expectedToStringBoeing787 = "Number of passengers: 440\n" + "Maximum speed: 956 km/h\n"
				+ "Maximum fuel consumption: 10.0 L/km";
		String actualToStringBoeing787 = boeing787.toString();
		assertEquals(expectedToStringBoeing787, actualToStringBoeing787,
				"Expected toString does not match actual toString");
	}

}
