import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The class PieTest contains JUnit tests for the class Pie.
 * 
 * @author Ignas Stakaitis
 * @version 01/12/2019
 */
class PieTest {
	public static final double TOLERANCE = 0.000001;
	Expenditure[] expendituresTest1 = new Expenditure[] { new Expenditure("Water", 1000),
			new Expenditure("Coffee", 500), new Expenditure("Soda", 200), new Expenditure("Tea", 700) };
	Expenditure[] expendituresTest2 = new Expenditure[] { new Expenditure("Water", 0), new Expenditure("Coffee", -500),
			new Expenditure("Soda", 45), new Expenditure("Tea", 100) };

	@Test
	public void testSortValue() {
		Pie.sort(expendituresTest1);
		int expectedTopExpenditureValue = 1000;
		int actualTopExpenditureValue = expendituresTest1[0].getValue();
		assertEquals(expectedTopExpenditureValue, actualTopExpenditureValue,
				"expected value does not match actual value.");
	}

	@Test
	public void testSortDescription() {
		Pie.sort(expendituresTest1);
		String expectedTopExpenditureDescription = "Water";
		String actualTopExpenditureDescription = expendituresTest1[0].getDescription();
		assertEquals(expectedTopExpenditureDescription, actualTopExpenditureDescription,
				"expected description does not match actual description.");
	}

	@Test
	public void testTotalExpenditure1() {
		int expectedTotalTest1 = 2400;
		int actualTotalTest1 = Pie.totalExpenditure(expendituresTest1);
		assertEquals(expectedTotalTest1, actualTotalTest1, "expected total does not equal to actual total.");
	}

	@Test
	public void testTotalExpenditure2() {
		int expectedTotalTest2 = -355;
		int actualTotalTest2 = Pie.totalExpenditure(expendituresTest2);
		assertEquals(expectedTotalTest2, actualTotalTest2, "expected total does not equal to actual total.");
	}

	@Test
	public void testExpendituresNormalised1() {
		int maximum = 4;
		double[] expenditures = Pie.expendituresNormalised(expendituresTest1, maximum);
		double expectedIndexOne = (2 * Math.PI) - (2 * Math.PI)
				* ((double) expendituresTest1[1-1].getValue() / Pie.totalExpenditure(expendituresTest1));
		double actualIndexOne = expenditures[1];
		assertEquals(expectedIndexOne, actualIndexOne, TOLERANCE, "expected value does not equal actual value.");
	}
	
	@Test
	public void testExpendituresNormalised2() {
		int maximum = 4;
		double[] expenditures = Pie.expendituresNormalised(expendituresTest2, maximum);
		double expectedIndexOne = (2 * Math.PI) - (2 * Math.PI)
				* ((double) expendituresTest2[1-1].getValue() / Pie.totalExpenditure(expendituresTest2));
		double actualIndexOne = expenditures[1];
		assertEquals(expectedIndexOne, actualIndexOne, TOLERANCE, "expected value does not equal actual value.");
	}
}
