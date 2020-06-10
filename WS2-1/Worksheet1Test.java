import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * @author Ignas Stakaitis
 * 
 *         This class contains the test cases for Worksheet1 solutions.
 */
public class Worksheet1Test {
	
	private List<Integer> listEmpty;
	private List<Integer> listZero;
	private List<Integer> listPositive;
	private List<Integer> listNegative;
	private List<Integer> listMixed;
	private List<Integer> listEven;
	private List<Integer> listOdd;
	private List<Integer> listSorted;


	@BeforeEach
	public void init() {
		listEmpty = new List<Integer>();
		listZero = new List<Integer>(0, new List<Integer>());
		listPositive = new List<Integer>(2, new List<Integer>(3, new List<Integer>(4, new List<Integer>())));
		listNegative = new List<Integer>(-2, new List<Integer>(-3, new List<Integer>(-4, new List<Integer>())));
		listMixed = new List<Integer>(-2, new List<Integer>(3, new List<Integer>(-4, new List<Integer>())));
		listEven = new List<Integer>(2, new List<Integer>(4, new List<Integer>(6, new List<Integer>())));
		listOdd = new List<Integer>(1, new List<Integer>(3, new List<Integer>(5, new List<Integer>())));
		listSorted = new List<Integer>(4, new List<Integer>(3, new List<Integer>(3, new List<Integer>())));
	}

	@Test
	public void powerTests() {
		assertEquals(1, Worksheet1.power(10, 0),
				"failure in powerTests: " + "expected result does not match actual result");
		assertEquals(5, Worksheet1.power(5, 1),
				"failure in powerTests: " + "expected result does not match actual result");
		assertEquals(3125, Worksheet1.power(5, 5),
				"failure in powerTests: " + "expected result does not match actual result");
		assertEquals(0, Worksheet1.power(0, 5),
				"failure in powerTests: " + "expected result does not match actual result");
	}

	@Test
	public void fastPowerTests() {
		assertEquals(1, Worksheet1.fastPower(10, 0),
				"failure in powerTests: " + "expected result does not match actual result");
		assertEquals(5, Worksheet1.fastPower(5, 1),
				"failure in powerTests: " + "expected result does not match actual result");
		assertEquals(3125, Worksheet1.fastPower(5, 5),
				"failure in powerTests: " + "expected result does not match actual result");
		assertEquals(0, Worksheet1.fastPower(0, 5),
				"failure in powerTests: " + "expected result does not match actual result");
	}

	@Test
	public void negateAllTests() {
		List<Integer> expectedListA = listEmpty;
		List<Integer> actualListA = Worksheet1.negateAll(listEmpty);
		assertEquals(expectedListA, actualListA,
				"failure in negateAllTests: " + "expected list does not match actual list");

		List<Integer> expectedListB = listZero;
		List<Integer> actualListB = Worksheet1.negateAll(listZero);
		assertEquals(expectedListB, actualListB,
				"failure in negateAllTests: " + "expected list does not match actual list");

		List<Integer> expectedListC = listNegative;
		List<Integer> actualListC = Worksheet1.negateAll(listPositive);
		assertEquals(expectedListC, actualListC,
				"failure in negateAllTests: " + "expected list does not match actual list");

		List<Integer> expectedListD = listPositive;
		List<Integer> actualListD = Worksheet1.negateAll(listNegative);
		assertEquals(expectedListD, actualListD,
				"failure in negateAllTests: " + "expected list does not match actual list");

		List<Integer> expectedListE = new List<Integer>(2,
				new List<Integer>(-3, new List<Integer>(4, new List<Integer>())));
		List<Integer> actualListE = Worksheet1.negateAll(listMixed);
		assertEquals(expectedListE, actualListE,
				"failure in negateAllTests: " + "expected list does not match actual list");
	}

	@Test
	public void findTests() {
		int integerA = 3;
		int integerB = 0;
		int integerC = 9;

		assertThrows(IllegalArgumentException.class, () -> {
			Worksheet1.find(integerA, listEmpty);
		}, "failure in findTests: " + "exception expected but not thrown");
		assertEquals(0, Worksheet1.find(integerB, listZero),
				"failure in findTests: " + "expected index does not match actual index");
		assertEquals(1, Worksheet1.find(integerA, listPositive),
				"failure in findTests: " + "expected index does not match actual index");
		assertThrows(IllegalArgumentException.class, () -> {
			Worksheet1.find(integerC, listMixed);
		}, "failure in findTests: " + "exception expected but not thrown");
		assertEquals(1, Worksheet1.find(integerA, listSorted),
				"failure in findTests: " + "expected index does not match actual index");
	}

	@Test
	public void allEvenTests() {
		assertEquals(true, Worksheet1.allEven(listEmpty),
				"failure in allEvenTests: " + "expected boolean does not match actual boolean");
		assertEquals(true, Worksheet1.allEven(listZero),
				"failure in allEvenTests: " + "expected boolean does not match actual boolean");
		assertEquals(true, Worksheet1.allEven(listEven),
				"failure in allEvenTests: " + "expected boolean does not match actual boolean");
		assertEquals(false, Worksheet1.allEven(listOdd),
				"failure in allEvenTests: " + "expected boolean does not match actual boolean");
		assertEquals(false, Worksheet1.allEven(listPositive),
				"failure in allEvenTests: " + "expected boolean does not match actual boolean");
	}

	@Test
	public void evenNumbersTests() {
		List<Integer> expectedListA = listEmpty;
		List<Integer> actualListA = Worksheet1.evenNumbers(listEmpty);
		assertEquals(expectedListA, actualListA,
				"failure in evenNumbersTests: " + "expected list does not match actual list");

		List<Integer> expectedListB = listZero;
		List<Integer> actualListB = Worksheet1.evenNumbers(listZero);
		assertEquals(expectedListB, actualListB,
				"failure in evenNumbersTests: " + "expected list does not match actual list");

		List<Integer> expectedListC = new List<Integer>(2, new List<Integer>(4, new List<Integer>()));
		List<Integer> actualListC = Worksheet1.evenNumbers(listPositive);
		assertEquals(expectedListC, actualListC,
				"failure in evenNumbersTests: " + "expected list does not match actual list");

		List<Integer> expectedListD = listEven;
		List<Integer> actualListD = Worksheet1.evenNumbers(listEven);
		assertEquals(expectedListD, actualListD,
				"failure in evenNumbersTests: " + "expected list does not match actual list");

		List<Integer> expectedListE = listEmpty;
		List<Integer> actualListE = Worksheet1.evenNumbers(listOdd);
		assertEquals(expectedListE, actualListE,
				"failure in evenNumbersTests: " + "expected list does not match actual list");

	}

	@Test
	public void sortedTests() {
		assertEquals(true, Worksheet1.sorted(listEmpty),
				"failure in sortedTests: " + "expected boolean does not match actual boolean");
		assertEquals(true, Worksheet1.sorted(listZero),
				"failure in sortedTests: " + "expected boolean does not match actual boolean");
		assertEquals(false, Worksheet1.sorted(listPositive),
				"failure in sortedTests: " + "expected boolean does not match actual boolean");
		assertEquals(true, Worksheet1.sorted(listNegative),
				"failure in sortedTests: " + "expected boolean does not match actual boolean");
		assertEquals(true, Worksheet1.sorted(listSorted),
				"failure in sortedTests: " + "expected boolean does not match actual boolean");
	}

	@Test
	public void mergeTests() {
		List<Integer> expectedListA = listEmpty;
		List<Integer> actualListA = Worksheet1.merge(listEmpty, listEmpty);
		assertEquals(expectedListA, actualListA,
				"failure in mergeTests: " + "expected list does not match actual list");

		List<Integer> expectedListB = listZero;
		List<Integer> actualListB = Worksheet1.merge(listZero, listEmpty);
		assertEquals(expectedListB, actualListB,
				"failure in mergeTests: " + "expected list does not match actual list");

		List<Integer> expectedListC = new List<Integer>(4, new List<Integer>(3, new List<Integer>(3,
				new List<Integer>(-2, new List<Integer>(-3, new List<Integer>(-4, new List<Integer>()))))));
		List<Integer> actualListC = Worksheet1.merge(listNegative, listSorted);
		assertEquals(expectedListC, actualListC,
				"failure in mergeTests: " + "expected list does not match actual list");

		List<Integer> expectedListD = new List<Integer>(-2, new List<Integer>(-2, new List<Integer>(-3,
				new List<Integer>(-3, new List<Integer>(-4, new List<Integer>(-4, new List<Integer>()))))));
		List<Integer> actualListD = Worksheet1.merge(listNegative, listNegative);
		assertEquals(expectedListD, actualListD,
				"failure in mergeTests: " + "expected list does not match actual list");

		List<Integer> expectedListE = new List<Integer>(4, new List<Integer>(4, new List<Integer>(3,
				new List<Integer>(3, new List<Integer>(3, new List<Integer>(3, new List<Integer>()))))));
		List<Integer> actualListE = Worksheet1.merge(listSorted, listSorted);
		assertEquals(expectedListE, actualListE,
				"failure in mergeTests: " + "expected list does not match actual list");

	}

	@Test
	public void removeDuplicatesTests() {
		List<Integer> expectedListA = listEmpty;
		List<Integer> actualListA = Worksheet1.removeDuplicates(listEmpty);
		assertEquals(expectedListA, actualListA,
				"failure in removeDuplicatesTests: " + "expected list does not match actual list");

		List<Integer> expectedListB = listZero;
		List<Integer> actualListB = Worksheet1.removeDuplicates(listZero);
		assertEquals(expectedListB, actualListB,
				"failure in removeDuplicatesTests: " + "expected list does not match actual list");

		List<Integer> expectedListC = new List<Integer>(4, new List<Integer>(3, new List<Integer>()));
		List<Integer> actualListC = Worksheet1.removeDuplicates(listSorted);
		assertEquals(expectedListC, actualListC,
				"failure in removeDuplicatesTests: " + "expected list does not match actual list");

		List<Integer> expectedListD = listZero;
		List<Integer> actualListD = Worksheet1.removeDuplicates(
				new List<Integer>(0, new List<Integer>(0, new List<Integer>(0, new List<Integer>()))));
		assertEquals(expectedListD, actualListD,
				"failure in removeDuplicatesTests: " + "expected list does not match actual list");

		List<Integer> expectedListE = listNegative;
		List<Integer> actualListE = Worksheet1.removeDuplicates(new List<Integer>(-2, new List<Integer>(-2,
				new List<Integer>(-3, new List<Integer>(-4, new List<Integer>(-4, new List<Integer>()))))));
		assertEquals(expectedListE, actualListE,
				"failure in removeDuplicatesTests: " + "expected list does not match actual list");
	}
}
