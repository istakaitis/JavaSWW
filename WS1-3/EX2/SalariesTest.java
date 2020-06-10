import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class SalariesTest contains JUnit tests for the class Salaries. The tests
 * target the methods average, averageSalaries and not3TimesHigher.
 * 
 * @author Ignas Stakaitis
 * @Version 30/10/2019
 *
 */
class SalariesTest {

	public static final double TOLERANCE = 0.0000000001;
	private Salaries salaries;
	double[] salaryJames = { 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000 };
	double[] salaryJohn = { 0, 0, 0, 0, 0, 0, 2000, 2000, 2000, 2000, 2000, 2000 };
	double[] salaryJim = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	double[] salaryJack = { -1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	double[] salaryJared = { 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 100000 };

	@BeforeEach
	public void init() {
		salaries = new Salaries();
	}

	@Test
	public void testAverage1() {
		double expectedAverage = 2000;
		double actualAverage = Salaries.average(salaryJohn);
		assertEquals(expectedAverage, actualAverage, TOLERANCE,
				"expected average is not equal to actual average of salaries.");
	}

	@Test
	public void testAverage2() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			Salaries.average(salaryJim);
		});
		assertEquals("Array must contain at least 1 non zero element.", e.getMessage());
	}

	@Test
	public void testAverageSalaries1() {
		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(2000.0);
		expectedAverageSalaries.add(2000.0);

		salaries.add(salaryJames);
		salaries.add(salaryJohn);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE,
					"expected average salaries ar not equal to actual average salaries.");
		}
	}

	@Test
	public void testAverageSalaries2() {
		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(2000.0);
		expectedAverageSalaries.add(-1000.0);

		salaries.add(salaryJohn);
		salaries.add(salaryJack);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE,
					"expected average salaries ar not equal to actual average salaries.");
		}
	}

	@Test
	public void testNot3TimesHigher1() {
		salaries.add(salaryJames);
		salaries.add(salaryJohn);
		assertTrue(salaries.not3TimesHigher());
	}

	@Test
	public void testNot3TimesHigher2() {
		salaries.add(salaryJack);
		salaries.add(salaryJared);
		assertFalse(salaries.not3TimesHigher());
	}

}
