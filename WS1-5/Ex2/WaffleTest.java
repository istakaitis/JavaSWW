import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * The class WaffleTest contains JUnit tests for the class Waffle.
 * 
 * @author Ignas Stakaitis
 * @version 01/12/2019
 */
class WaffleTest {

	Expenditure[] expendituresTest1 = new Expenditure[] { new Expenditure("Games", 110), new Expenditure("Movies", 20),
			new Expenditure("Bus", 50), new Expenditure("Food", 300) };
	Expenditure[] expendituresTest2 = new Expenditure[] { new Expenditure("Games", -100), new Expenditure("Movies", 0),
			new Expenditure("Bus", 50), new Expenditure("Food", 200) };

	@Test
	public void testSortValue() {
		Waffle.sort(expendituresTest1);
		int expectedTopExpenditureValue = 300;
		int actualTopExpenditureValue = expendituresTest1[0].getValue();
		assertEquals(expectedTopExpenditureValue, actualTopExpenditureValue,
				"expected value does not match actual value.");
	}

	@Test
	public void testSortDescription() {
		Waffle.sort(expendituresTest1);
		String expectedTopExpenditureDescription = "Food";
		String actualTopExpenditureDescription = expendituresTest1[0].getDescription();
		assertEquals(expectedTopExpenditureDescription, actualTopExpenditureDescription,
				"expected description does not match actual description.");
	}

	@Test
	public void testTotalExpenditure1() {
		int expectedTotalTest1 = 480;
		int actualTotalTest1 = Waffle.totalExpenditure(expendituresTest1);
		assertEquals(expectedTotalTest1, actualTotalTest1, "expected total does not equal to actual total.");
	}

	@Test
	public void testTotalExpenditure2() {
		int expectedTotalTest2 = 150;
		int actualTotalTest2 = Waffle.totalExpenditure(expendituresTest2);
		assertEquals(expectedTotalTest2, actualTotalTest2, "expected total does not equal to actual total.");
	}

	@Test
	public void testMakeColourArrayZeroIndex() {
		int maximum = expendituresTest1.length;
		Color[] colours = Waffle.makeColourArray(maximum);
		Color expectedColour1 = Color.BLACK;
		Color actualColour1 = colours[0];
		assertEquals(expectedColour1, actualColour1, "expected colour does not match actual colour.");
	}

	@Test
	public void testMakeColourArrayFinalIndex() {
		int maximum = expendituresTest1.length;
		Color[] colours = Waffle.makeColourArray(maximum);
		Color expectedColourFinal = Color.YELLOW;
		Color actualColourFinal = colours[maximum - 1];
		assertEquals(expectedColourFinal, actualColourFinal, "expected colour does not match actual colour.");
	}

	@Test
	public void testNumberOfSquares1() {
		Waffle.sort(expendituresTest1);
		int[] finalSquares = Waffle.numberOfSquares(expendituresTest1);
		int expectedZeroIndex = 63;
		int actualZeroIndex = finalSquares[0];
		assertEquals(expectedZeroIndex, actualZeroIndex,
				"expected number of squares is not equal to actual number of squares.");

		int totalSquares = 0;
		for (int i = 0; i < finalSquares.length; i++) {
			totalSquares += finalSquares[i];
		}
		int expectedTotal = 100;
		int actualTotal = totalSquares;
		assertEquals(expectedTotal, actualTotal, "expected total does not equal to actual total.");
	}

	@Test
	// this test shows that the method does not handle negative values well.
	public void testNumberOfSquares2() {
		Waffle.sort(expendituresTest2);
		int[] finalSquares = Waffle.numberOfSquares(expendituresTest2);
		int expectedZeroIndex = 134;
		int actualZeroIndex = finalSquares[0];
		assertEquals(expectedZeroIndex, actualZeroIndex,
				"expected number of squares is not equal to actual number of squares.");

		int totalSquares = 0;
		for (int i = 0; i < finalSquares.length; i++) {
			totalSquares += finalSquares[i];
		}
		int expectedTotal = 100;
		int actualTotal = totalSquares;
		assertEquals(expectedTotal, actualTotal, "expected total does not equal to actual total.");
	}

}
