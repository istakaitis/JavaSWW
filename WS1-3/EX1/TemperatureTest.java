import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class TemperatureTest includes the JUnit tests for the class Temperature.
 * 
 * @author Ignas Stakaitis
 * @version 30/10/2019
 */
class TemperatureTest {

	public static final double TOLERANCE = 0.0000000001;

	@Test
	public void testColdest1() {
		double[] temperatures1 = { 21, 19, 5, 17, 4, 3, 6, 4, 34, 17, 17, 18, 27, 7, 9, 7, 9, 23, 30, 20, 9, 8, 26, 18,
				8, 17, 12, 29, 5, 23, 12, 7, 32, 10, 12, 19, 27, 20, 32, 21, 16, 15, 12, 8, 7, 33, 15, 13, 2, 21, 9, 9,
				26, 9, 11, 23, 18, 13, 5, 21, 33, 13, 14, 34, 22, 31, 34, 14, 13, 31, 3, 19, 30, 27, 11, 13, 1, 12, 30,
				30, 14, 2, 12, 22, 8, 17, 0, 11, 26, 29, 13, 25, 32, 26, 30, 30, 6, 8, 10, 12, 18, 19, 29, 18, 28, 32,
				11, 20, 16, 34, 23, 9, 29, 4, 24, 5, 24, 28, 25, 2, 25, 31, 4, 3, 20, 3, 2, 23, 34, 31, 12, 10, 32, 27,
				7, 26, 16, 6, 25, 19, 24, 15, 30, 28, 0, 33, 28, 34, 20, 22, 4, 35, 16, 7, 17, 34, 29, 13, 8, 25, 18,
				28, 20, 22, 0, 34, 30, 25, 20, 25, 13, 19, 7, 31, 5, 17, 1, 35, 28, 34, 25, 28, 28, 27, 35, 11, 3, 31,
				1, 30, 26, 29, 0, 32, 7, 28, 25, 12, 34, 16, 27, 11, 13, 7, 5, 1, 3, 31, 8, 21, 22, 4, 23, 1, 18, 5, 25,
				16, 28, 4, 15, 33, 18, 15, 24, 31, 28, 30, 8, 11, 13, 30, 25, 14, 20, 12, 13, 5, 30, 5, 24, 12, 2, 5,
				34, 24, 33, 33, 31, 4, 3, 25, 2, 32, 34, 8, 32, 25, 33, 20, 33, 26, 17, 2, 7, 32, 29, 0, 27, 16, 3, 25,
				11, 23, 23, 16, 9, 33, 7, 29, 19, 8, 2, 4, 14, 31, 22, 22, 5, 25, 31, 19, 21, 3, 18, 32, 14, 22, 15, 6,
				14, 8, 10, 34, 3, 11, 5, 13, 0, 8, 21, 30, 15, 34, 30, 28, 25, 16, 1, 33, 33, 11, 32, 13, 29, 23, 6, 21,
				31, 31, 14, 1, 4, 20, 5, 5, 35, 2, 19, 16, 32, 17, 11, 10, 24, 35, 15, 31, 25, 18, 8, 31, 21, 28, 30, 4,
				26, 2, 7, 17, 26, 4, 22, 11, 16 };

		int expectedColdest = 87;
		int actualColdest = Temperature.coldest(temperatures1);
		assertEquals(expectedColdest, actualColdest, TOLERANCE,
				"expected coldest day does not match actual coldest day");
	}

	@Test
	public void testColdest2() {
		double[] temperatures2 = { 0.02, -30.20, -30.20, 10.05, 5.56 };

		int expectedColdest = 2;
		int actualColdest = Temperature.coldest(temperatures2);
		assertEquals(expectedColdest, actualColdest, TOLERANCE,
				"expected coldest day does not match actual coldest day");
	}

	@Test
	public void testColdest3() {
		double temperatures3[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int expectedColdest = 1;
		int actualColdest = Temperature.coldest(temperatures3);
		assertEquals(expectedColdest, actualColdest, TOLERANCE,
				"expected coldest day does not match actual coldest day");
	}

	@Test
	public void testColdest4() {
		double temperatures4[] = { 0 };

		int expectedColdest = 1;
		int actualColdest = Temperature.coldest(temperatures4);
		assertEquals(expectedColdest, actualColdest, TOLERANCE,
				"expected coldest day does not match actual coldest day");
	}

}
