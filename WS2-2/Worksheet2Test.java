import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * @author Ignas Stakaitis
 * 
 *         This class contains the test cases for Worksheet2 solutions.
 */

public class Worksheet2Test {

	private Tree<Integer> treeEmpty;
	private Tree<Integer> treeZero;
	private Tree<Integer> treePositive;
	private Tree<Integer> treeNegative;
	private Tree<Integer> treeMixed;
	private Tree<Integer> treeOddAndEven;
	private Tree<Integer> searchTreePositive;
	private Tree<Integer> searchTreeNegative;
	private Tree<Integer> searchTreeLarge;
	private Tree<Integer> unbalancedLL;
	private Tree<Integer> unbalancedRR;
	private Tree<Integer> unbalancedLR;
	private Tree<Integer> unbalancedRL;
	private Tree<Integer> balancedA;
	private Tree<Integer> balancedB;
	private Tree<Integer> balancedC;
	private Tree<Integer> balancedD;
	private Tree<Integer> balancedE;

	@BeforeEach
	public void init() {
		treeEmpty = new Tree<Integer>();
		treeZero = new Tree<Integer>(0);
		treePositive = new Tree<Integer>(3, new Tree<Integer>(2), new Tree<Integer>(1));
		treeNegative = new Tree<Integer>(-3, new Tree<Integer>(-2), new Tree<Integer>(-1));
		treeMixed = new Tree<Integer>(10, new Tree<Integer>(-8, new Tree<Integer>(4), new Tree<Integer>()),
				new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>(-6)));
		treeOddAndEven = new Tree<Integer>(4, new Tree<Integer>(2), new Tree<Integer>(5));
		searchTreePositive = new Tree<Integer>(4, new Tree<Integer>(2), new Tree<Integer>(6));
		searchTreeNegative = new Tree<Integer>(-4, new Tree<Integer>(-6), new Tree<Integer>(-2));
		searchTreeLarge = new Tree<Integer>(10, new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)),
				new Tree<Integer>(15, new Tree<Integer>(12), new Tree<Integer>(18)));
		unbalancedLL = new Tree<Integer>(50, new Tree<Integer>(40, new Tree<Integer>(30), new Tree<Integer>()),
				new Tree<Integer>());
		unbalancedRR = new Tree<Integer>(50, new Tree<Integer>(),
				new Tree<Integer>(60, new Tree<Integer>(), new Tree<Integer>(70)));
		unbalancedLR = new Tree<Integer>(50, new Tree<Integer>(40, new Tree<Integer>(), new Tree<Integer>(45)),
				new Tree<Integer>());
		unbalancedRL = new Tree<Integer>(40, new Tree<Integer>(),
				new Tree<Integer>(70, new Tree<Integer>(60), new Tree<Integer>()));
		balancedA = new Tree<Integer>(10, new Tree<Integer>(5, new Tree<Integer>(3), new Tree<Integer>()),
				new Tree<Integer>(15));
		balancedB = new Tree<Integer>(15, new Tree<Integer>(10),
				new Tree<Integer>(30, new Tree<Integer>(), new Tree<Integer>(40)));
		balancedC = new Tree<Integer>(20, new Tree<Integer>(10, new Tree<Integer>(5), new Tree<Integer>(15)),
				new Tree<Integer>(30));
		balancedD = new Tree<Integer>(20, new Tree<Integer>(10),
				new Tree<Integer>(30, new Tree<Integer>(25), new Tree<Integer>(35)));
		balancedE = new Tree<Integer>(20, new Tree<Integer>(10, new Tree<Integer>(5), new Tree<Integer>()),
				new Tree<Integer>(30, new Tree<Integer>(25),
						new Tree<Integer>(35, new Tree<Integer>(32), new Tree<Integer>(50))));
	}

	@Test
	public void negateAllTests() {
		assertEquals(treeEmpty, Worksheet2.negateAll(treeEmpty),
				"failure in negateAllTests: " + "expected list does not match actual list");
		assertEquals(treeZero, Worksheet2.negateAll(treeZero),
				"failure in negateAllTests: " + "expected list does not match actual list");
		assertEquals(treePositive, Worksheet2.negateAll(treeNegative),
				"failure in negateAllTests: " + "expected list does not match actual list");
		assertEquals(treeNegative, Worksheet2.negateAll(treePositive),
				"failure in negateAllTests: " + "expected list does not match actual list");
		Tree<Integer> expectedTree = new Tree<Integer>(-10,
				new Tree<Integer>(8, new Tree<Integer>(-4, new Tree<Integer>(), new Tree<Integer>()),
						new Tree<Integer>()),
				new Tree<Integer>(-2, new Tree<Integer>(),
						new Tree<Integer>(6, new Tree<Integer>(), new Tree<Integer>())));
		assertEquals(expectedTree, Worksheet2.negateAll(treeMixed),
				"failure in negateAllTests: " + "expected list does not match actual list");
	}

	@Test
	public void allEvenTests() {
		assertTrue(Worksheet2.allEven(treeEmpty), "failure in allEvenTests: " + "expected true but returned false");
		assertTrue(Worksheet2.allEven(treeZero), "failure in allEvenTests: " + "expected true but returned false");
		assertFalse(Worksheet2.allEven(treeOddAndEven),
				"failure in allEvenTests: " + "expected false but returned true");
		assertFalse(Worksheet2.allEven(treeNegative), "failure in allEvenTests: " + "expected false but returned true");
		assertTrue(Worksheet2.allEven(treeMixed), "failure in allEvenTests: " + "expected true but returned false");
	}

	@Test
	public void depthTests() {
		assertEquals(-1, Worksheet2.depth(treeEmpty, 0),
				"failure in depthTests: " + "expected depth does not match actual depth");
		assertEquals(0, Worksheet2.depth(treeZero, 0),
				"failure in depthTests: " + "expected depth does not match actual depth");
		assertEquals(-1, Worksheet2.depth(treePositive, 10),
				"failure in depthTests: " + "expected depth does not match actual depth");
		assertEquals(2, Worksheet2.depth(treeMixed, -6),
				"failure in depthTests: " + "expected depth does not match actual depth");
		assertEquals(1, Worksheet2.depth(treeMixed, 2),
				"failure in depthTests: " + "expected depth does not match actual depth");
	}

	@Test
	public void preorderTests() {
		List<Integer> expectedListA = new List<Integer>();
		List<Integer> actualListA = Worksheet2.preorder(treeEmpty);
		assertEquals(expectedListA, actualListA,
				"failure in preorderTests: " + "expected list does not match actual list");

		List<Integer> expectedListB = new List<Integer>(0, new List<Integer>());
		List<Integer> actualListB = Worksheet2.preorder(treeZero);
		assertEquals(expectedListB, actualListB,
				"failure in preorderTests: " + "expected list does not match actual list");

		List<Integer> expectedListC = new List<Integer>(4,
				new List<Integer>(2, new List<Integer>(6, new List<Integer>())));
		List<Integer> actualListC = Worksheet2.preorder(searchTreePositive);
		assertEquals(expectedListC, actualListC,
				"failure in preorderTests: " + "expected list does not match actual list");

		List<Integer> expectedListD = new List<Integer>(-4,
				new List<Integer>(-6, new List<Integer>(-2, new List<Integer>())));
		List<Integer> actualListD = Worksheet2.preorder(searchTreeNegative);
		assertEquals(expectedListD, actualListD,
				"failure in preorderTests: " + "expected list does not match actual list");

	}

	@Test
	public void isSearchTreeTests() {
		assertTrue(Worksheet2.isSearchTree(treeEmpty),
				"failure in isSearchTreeTests: " + "expected true but returned false");
		assertTrue(Worksheet2.isSearchTree(treeZero),
				"failure in isSearchTreeTests: " + "expected true but returned false");
		assertFalse(Worksheet2.isSearchTree(treePositive),
				"failure in isSearchTreeTests: " + "expected false but returned true");
		assertFalse(Worksheet2.isSearchTree(treeNegative),
				"failure in isSearchTreeTests: " + "expected false but returned true");
		assertTrue(Worksheet2.isSearchTree(searchTreePositive),
				"failure in isSearchTreeTests: " + "expected true but returned false");
		assertTrue(Worksheet2.isSearchTree(searchTreeNegative),
				"failure in isSearchTreeTests: " + "expected true but returned false");
	}

	@Test
	public void maxTests() {
		assertThrows(IllegalStateException.class, () -> {
			Worksheet2.max(treeEmpty);
		}, "failure in maxTests: " + "exception expected but not thrown");
		assertEquals(0, Worksheet2.max(treeZero),
				"failure in maxTests: " + "expected maximum does not match actual maximum");
		assertEquals(6, Worksheet2.max(searchTreePositive),
				"failure in maxTests: " + "expected maximum does not match actual maximum");
		assertEquals(-2, Worksheet2.max(searchTreeNegative),
				"failure in maxTests: " + "expected maximum does not match actual maximum");
		assertEquals(18, Worksheet2.max(searchTreeLarge),
				"failure in maxTests: " + "expected maximum does not match actual maximum");
	}

	@Test
	public void deleteTests() {
		Tree<Integer> expectedTreeA = treeEmpty;
		Tree<Integer> actualTreeA = Worksheet2.delete(treeEmpty, 10);
		assertEquals(expectedTreeA, actualTreeA,
				"failure in deleteTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeB = treeEmpty;
		Tree<Integer> actualTreeB = Worksheet2.delete(treeZero, 0);
		assertEquals(expectedTreeB, actualTreeB,
				"failure in deleteTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeC = new Tree<Integer>(4, new Tree<Integer>(2), new Tree<Integer>());
		Tree<Integer> actualTreeC = Worksheet2.delete(searchTreePositive, 6);
		assertEquals(expectedTreeC, actualTreeC,
				"failure in deleteTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeD = new Tree<Integer>(4, new Tree<Integer>(), new Tree<Integer>(6));
		Tree<Integer> actualTreeD = Worksheet2.delete(searchTreePositive, 2);
		assertEquals(expectedTreeD, actualTreeD,
				"failure in deleteTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeE = new Tree<Integer>(4, new Tree<Integer>(2), new Tree<Integer>(6));
		Tree<Integer> actualTreeE = Worksheet2.delete(searchTreePositive, 1);
		assertEquals(expectedTreeE, actualTreeE,
				"failure in deleteTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeF = new Tree<Integer>(4, new Tree<Integer>(2), new Tree<Integer>(6));
		Tree<Integer> actualTreeF = Worksheet2.delete(searchTreePositive, 1);
		assertEquals(expectedTreeF, actualTreeF,
				"failure in deleteTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeG = new Tree<Integer>(6,
				new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>()),
				new Tree<Integer>(15, new Tree<Integer>(12), new Tree<Integer>(18)));
		Tree<Integer> actualTreeG = Worksheet2.delete(searchTreeLarge, 10);
		assertEquals(expectedTreeG, actualTreeG,
				"failure in deleteTests: " + "expected tree does not match actual tree");

	}

	@Test
	public void isHeightBalancedTests() {
		assertTrue(Worksheet2.isHeightBalanced(treeEmpty),
				"failure in isHeightBalancedTests: " + "expected true but returned false");
		assertTrue(Worksheet2.isHeightBalanced(treeZero),
				"failure in isHeightBalancedTests: " + "expected true but returned false");
		assertTrue(Worksheet2.isHeightBalanced(searchTreeNegative),
				"failure in isHeightBalancedTests: " + "expected true but returned false");
		assertTrue(Worksheet2.isHeightBalanced(searchTreeLarge),
				"failure in isHeightBalancedTests: " + "expected true but returned false");
		assertFalse(Worksheet2.isHeightBalanced(unbalancedLL),
				"failure in isHeightBalancedTests: " + "expected false but returned true");
		assertFalse(Worksheet2.isHeightBalanced(unbalancedRR),
				"failure in isHeightBalancedTests: " + "expected false but returned true");
		assertFalse(Worksheet2.isHeightBalanced(unbalancedLR),
				"failure in isHeightBalancedTests: " + "expected false but returned true");
		assertFalse(Worksheet2.isHeightBalanced(unbalancedRL),
				"failure in isHeightBalancedTests: " + "expected false but returned true");
	}

	@Test
	public void insertHBTests() {
		Tree<Integer> expectedTreeA = new Tree<Integer>(10);
		Tree<Integer> actualTreeA = Worksheet2.insertHB(treeEmpty, 10);
		assertEquals(expectedTreeA, actualTreeA,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeB = new Tree<Integer>(0, new Tree<Integer>(-5), new Tree<Integer>());
		Tree<Integer> actualTreeB = Worksheet2.insertHB(treeZero, -5);
		assertEquals(expectedTreeB, actualTreeB,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeC = new Tree<Integer>(10,
				new Tree<Integer>(5, new Tree<Integer>(4), new Tree<Integer>(6)), new Tree<Integer>(15,
						new Tree<Integer>(12), new Tree<Integer>(18, new Tree<Integer>(17), new Tree<Integer>())));
		Tree<Integer> actualTreeC = Worksheet2.insertHB(searchTreeLarge, 17);
		assertEquals(expectedTreeC, actualTreeC,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeD = new Tree<Integer>(10,
				new Tree<Integer>(3, new Tree<Integer>(1), new Tree<Integer>(5)), new Tree<Integer>(15));
		Tree<Integer> actualTreeD = Worksheet2.insertHB(balancedA, 1);
		assertEquals(expectedTreeD, actualTreeD,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeE = new Tree<Integer>(15, new Tree<Integer>(10),
				new Tree<Integer>(40, new Tree<Integer>(30), new Tree<Integer>(50)));
		Tree<Integer> actualTreeE = Worksheet2.insertHB(balancedB, 50);
		assertEquals(expectedTreeE, actualTreeE,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeF = new Tree<Integer>(10,
				new Tree<Integer>(4, new Tree<Integer>(3), new Tree<Integer>(5)), new Tree<Integer>(15));
		Tree<Integer> actualTreeF = Worksheet2.insertHB(balancedA, 4);
		assertEquals(expectedTreeF, actualTreeF,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeG = new Tree<Integer>(15, new Tree<Integer>(10),
				new Tree<Integer>(35, new Tree<Integer>(30), new Tree<Integer>(40)));
		Tree<Integer> actualTreeG = Worksheet2.insertHB(balancedB, 35);
		assertEquals(expectedTreeG, actualTreeG,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeH = new Tree<Integer>(15,
				new Tree<Integer>(10, new Tree<Integer>(5), new Tree<Integer>(12)),
				new Tree<Integer>(20, new Tree<Integer>(), new Tree<Integer>(30)));
		Tree<Integer> actualTreeH = Worksheet2.insertHB(balancedC, 12);
		assertEquals(expectedTreeH, actualTreeH,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeI = new Tree<Integer>(15,
				new Tree<Integer>(10, new Tree<Integer>(5), new Tree<Integer>()),
				new Tree<Integer>(20, new Tree<Integer>(17), new Tree<Integer>(30)));
		Tree<Integer> actualTreeI = Worksheet2.insertHB(balancedC, 17);
		assertEquals(expectedTreeI, actualTreeI,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeJ = new Tree<Integer>(25,
				new Tree<Integer>(20, new Tree<Integer>(10), new Tree<Integer>(23)),
				new Tree<Integer>(30, new Tree<Integer>(), new Tree<Integer>(35)));
		Tree<Integer> actualTreeJ = Worksheet2.insertHB(balancedD, 23);
		assertEquals(expectedTreeJ, actualTreeJ,
				"failure in insertHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeK = new Tree<Integer>(25,
				new Tree<Integer>(20, new Tree<Integer>(10), new Tree<Integer>()),
				new Tree<Integer>(30, new Tree<Integer>(27), new Tree<Integer>(35)));
		Tree<Integer> actualTreeK = Worksheet2.insertHB(balancedD, 27);
		assertEquals(expectedTreeK, actualTreeK,
				"failure in insertHBTests: " + "expected tree does not match actual tree");
	}

	@Test
	public void deleteHBTests() {
		Tree<Integer> expectedTreeA = treeEmpty;
		Tree<Integer> actualTreeA = Worksheet2.deleteHB(treeEmpty, 10);
		assertEquals(expectedTreeA, actualTreeA,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeB = treeEmpty;
		Tree<Integer> actualTreeB = Worksheet2.deleteHB(treeZero, 0);
		assertEquals(expectedTreeB, actualTreeB,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeC = new Tree<Integer>(5, new Tree<Integer>(3), new Tree<Integer>(10));
		Tree<Integer> actualTreeC = Worksheet2.deleteHB(balancedA, 15);
		assertEquals(expectedTreeC, actualTreeC,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeD = new Tree<Integer>(30, new Tree<Integer>(15), new Tree<Integer>(40));
		Tree<Integer> actualTreeD = Worksheet2.deleteHB(balancedB, 10);
		assertEquals(expectedTreeD, actualTreeD,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeE = new Tree<Integer>(10, new Tree<Integer>(5),
				new Tree<Integer>(20, new Tree<Integer>(15), new Tree<Integer>()));
		Tree<Integer> actualTreeE = Worksheet2.deleteHB(balancedC, 30);
		assertEquals(expectedTreeE, actualTreeE,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeF = new Tree<Integer>(30,
				new Tree<Integer>(20, new Tree<Integer>(10), new Tree<Integer>(25)),
				new Tree<Integer>(35, new Tree<Integer>(32), new Tree<Integer>(50)));
		Tree<Integer> actualTreeF = Worksheet2.deleteHB(balancedE, 5);
		assertEquals(expectedTreeF, actualTreeF,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");

		Tree<Integer> expectedTreeG = new Tree<Integer>(30,
				new Tree<Integer>(20, new Tree<Integer>(), new Tree<Integer>(25)), new Tree<Integer>(35));
		Tree<Integer> actualTreeG = Worksheet2.deleteHB(balancedD, 10);
		assertEquals(expectedTreeG, actualTreeG,
				"failure in deleteHBTests: " + "expected tree does not match actual tree");
	}

}