package predictive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

/**
 * This class contains the JUnit tests for the methods contained in the classes
 * within the predictive package.
 * 
 * @author Ignas Stakaitis
 *
 */
class Tests {

	@Test
	public void wordToSignatureTest() {
		assertEquals("", PredictivePrototype.wordToSignature(""),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals(" ", PredictivePrototype.wordToSignature("!"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("966", PredictivePrototype.wordToSignature("zoo"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("4663", PredictivePrototype.wordToSignature("Home"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("778273 ", PredictivePrototype.wordToSignature("square?"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("842553", PredictivePrototype.wordToSignature("tickle"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("96753 627", PredictivePrototype.wordToSignature("World Map"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("234567899", PredictivePrototype.wordToSignature("bfgjnpvxy"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
		assertEquals("234567899", PredictivePrototype.wordToSignature("BFGJNPVXY"),
				"failure in wordToSignatureTest: " + "expected signature does not match actual signature.");
	}

	@Test
	public void isValidWordTest() {
		assertFalse(PredictivePrototype.isValidWord(""),
				"failure in isValidWordTest: " + "expected false but returned true");
		assertTrue(PredictivePrototype.isValidWord("a"),
				"failure in isValidWordTest: " + "expected true but returned false");
		assertTrue(PredictivePrototype.isValidWord("Hello"),
				"failure in isValidWordTest: " + "expected true but returned false");
		assertFalse(PredictivePrototype.isValidWord(" "),
				"failure in isValidWordTest: " + "expected false but returned true");
		assertFalse(PredictivePrototype.isValidWord("Hello, World!"),
				"failure in isValidWordTest: " + "expected false but returned true");
		assertFalse(PredictivePrototype.isValidWord("1234"),
				"failure in isValidWordTest: " + "expected false but returned true");
	}

	@Test
	public void predictivePrototypeSignatureToWordsTest() {
		Set<String> expectedSetA = new TreeSet<String>();
		Set<String> actualSetA = PredictivePrototype.signatureToWords("");
		assertEquals(expectedSetA, actualSetA,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetB = new TreeSet<String>();
		Set<String> actualSetB = PredictivePrototype.signatureToWords(" ");
		assertEquals(expectedSetB, actualSetB,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetC = new TreeSet<String>();
		Set<String> actualSetC = PredictivePrototype.signatureToWords("abc");
		assertEquals(expectedSetC, actualSetC,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetD = new TreeSet<String>();
		expectedSetD.add("daw");
		expectedSetD.add("dax");
		expectedSetD.add("day");
		expectedSetD.add("dbw");
		expectedSetD.add("fax");
		expectedSetD.add("fay");
		expectedSetD.add("fcy");
		Set<String> actualSetD = PredictivePrototype.signatureToWords("329");
		assertEquals(expectedSetD, actualSetD,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetE = new TreeSet<String>();
		expectedSetE.add("gekko");
		expectedSetE.add("hello");
		Set<String> actualSetE = PredictivePrototype.signatureToWords("43556");
		assertEquals(expectedSetE, actualSetE,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetF = new TreeSet<String>();
		expectedSetF.add("jug");
		expectedSetF.add("kui");
		expectedSetF.add("ltg");
		expectedSetF.add("lth");
		expectedSetF.add("lug");
		Set<String> actualSetF = PredictivePrototype.signatureToWords("584");
		assertEquals(expectedSetF, actualSetF,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetG = new TreeSet<String>();
		Set<String> actualSetG = PredictivePrototype.signatureToWords("5849");
		assertEquals(expectedSetG, actualSetG,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetH = new TreeSet<String>();
		expectedSetH.add("a");
		expectedSetH.add("b");
		expectedSetH.add("c");
		Set<String> actualSetH = PredictivePrototype.signatureToWords("2");
		assertEquals(expectedSetH, actualSetH,
				"failure in predictivePrototypeSignatureToWordsTest: " + "expected set does not match actual set");

	}

	@Test
	public void listDictionarySignatureToWordsTest() {
		ListDictionary dict = new ListDictionary("/usr/share/dict/words");

		Set<String> expectedSetA = new TreeSet<String>();
		Set<String> actualSetA = dict.signatureToWords("");
		assertEquals(expectedSetA, actualSetA,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetB = new TreeSet<String>();
		Set<String> actualSetB = dict.signatureToWords(" ");
		assertEquals(expectedSetB, actualSetB,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetC = new TreeSet<String>();
		Set<String> actualSetC = dict.signatureToWords("abc");
		assertEquals(expectedSetC, actualSetC,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetD = new TreeSet<String>();
		expectedSetD.add("daw");
		expectedSetD.add("dax");
		expectedSetD.add("day");
		expectedSetD.add("dbw");
		expectedSetD.add("fax");
		expectedSetD.add("fay");
		expectedSetD.add("fcy");
		Set<String> actualSetD = dict.signatureToWords("329");
		assertEquals(expectedSetD, actualSetD,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetE = new TreeSet<String>();
		expectedSetE.add("gekko");
		expectedSetE.add("hello");
		Set<String> actualSetE = dict.signatureToWords("43556");
		assertEquals(expectedSetE, actualSetE,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetF = new TreeSet<String>();
		expectedSetF.add("jug");
		expectedSetF.add("kui");
		expectedSetF.add("ltg");
		expectedSetF.add("lth");
		expectedSetF.add("lug");
		Set<String> actualSetF = dict.signatureToWords("584");
		assertEquals(expectedSetF, actualSetF,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetG = new TreeSet<String>();
		Set<String> actualSetG = dict.signatureToWords("5849");
		assertEquals(expectedSetG, actualSetG,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetH = new TreeSet<String>();
		expectedSetH.add("a");
		expectedSetH.add("b");
		expectedSetH.add("c");
		Set<String> actualSetH = dict.signatureToWords("2");
		assertEquals(expectedSetH, actualSetH,
				"failure in listDictionarySignatureToWordsTest: " + "expected set does not match actual set");
	}

	@Test
	public void mapDictionarySignatureToWordsTest() {
		MapDictionary dict = new MapDictionary("/usr/share/dict/words");

		Set<String> expectedSetA = new TreeSet<String>();
		Set<String> actualSetA = dict.signatureToWords("");
		assertEquals(expectedSetA, actualSetA,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetB = new TreeSet<String>();
		Set<String> actualSetB = dict.signatureToWords(" ");
		assertEquals(expectedSetB, actualSetB,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetC = new TreeSet<String>();
		Set<String> actualSetC = dict.signatureToWords("abc");
		assertEquals(expectedSetC, actualSetC,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetD = new TreeSet<String>();
		expectedSetD.add("daw");
		expectedSetD.add("dax");
		expectedSetD.add("day");
		expectedSetD.add("dbw");
		expectedSetD.add("fax");
		expectedSetD.add("fay");
		expectedSetD.add("fcy");
		Set<String> actualSetD = dict.signatureToWords("329");
		assertEquals(expectedSetD, actualSetD,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetE = new TreeSet<String>();
		expectedSetE.add("gekko");
		expectedSetE.add("hello");
		Set<String> actualSetE = dict.signatureToWords("43556");
		assertEquals(expectedSetE, actualSetE,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetF = new TreeSet<String>();
		expectedSetF.add("jug");
		expectedSetF.add("kui");
		expectedSetF.add("ltg");
		expectedSetF.add("lth");
		expectedSetF.add("lug");
		Set<String> actualSetF = dict.signatureToWords("584");
		assertEquals(expectedSetF, actualSetF,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetG = new TreeSet<String>();
		Set<String> actualSetG = dict.signatureToWords("5849");
		assertEquals(expectedSetG, actualSetG,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetH = new TreeSet<String>();
		expectedSetH.add("a");
		expectedSetH.add("b");
		expectedSetH.add("c");
		Set<String> actualSetH = dict.signatureToWords("2");
		assertEquals(expectedSetH, actualSetH,
				"failure in mapDictionarySignatureToWordsTest: " + "expected set does not match actual set");
	}

	@Test
	public void treeDictionarySignatureToWordsTest() {
		TreeDictionary dict = new TreeDictionary("/usr/share/dict/words");

		Set<String> expectedSetA = new TreeSet<String>();
		Set<String> actualSetA = dict.signatureToWords("");
		assertEquals(expectedSetA, actualSetA,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetB = new TreeSet<String>();
		Set<String> actualSetB = dict.signatureToWords(" ");
		assertEquals(expectedSetB, actualSetB,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetC = new TreeSet<String>();
		Set<String> actualSetC = dict.signatureToWords("abc");
		assertEquals(expectedSetC, actualSetC,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetD = new TreeSet<String>();
		expectedSetD.add("daw");
		expectedSetD.add("dax");
		expectedSetD.add("day");
		expectedSetD.add("daz");
		expectedSetD.add("dbw");
		expectedSetD.add("ecy");
		expectedSetD.add("ecz");
		expectedSetD.add("faw");
		expectedSetD.add("fax");
		expectedSetD.add("fay");
		expectedSetD.add("faz");
		expectedSetD.add("fcy");
		Set<String> actualSetD = dict.signatureToWords("329");
		assertEquals(expectedSetD, actualSetD,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetE = new TreeSet<String>();
		expectedSetE.add("gekko");
		expectedSetE.add("gellm");
		expectedSetE.add("hellm");
		expectedSetE.add("helln");
		expectedSetE.add("hello");
		Set<String> actualSetE = dict.signatureToWords("43556");
		assertEquals(expectedSetE, actualSetE,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetF = new TreeSet<String>();
		expectedSetF.add("jti");
		expectedSetF.add("jug");
		expectedSetF.add("jui");
		expectedSetF.add("kth");
		expectedSetF.add("kug");
		expectedSetF.add("kuh");
		expectedSetF.add("kui");
		expectedSetF.add("kvi");
		expectedSetF.add("ltg");
		expectedSetF.add("lth");
		expectedSetF.add("lug");
		expectedSetF.add("luh");
		expectedSetF.add("lui");
		expectedSetF.add("lvi");
		Set<String> actualSetF = dict.signatureToWords("584");
		assertEquals(expectedSetF, actualSetF,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetG = new TreeSet<String>();
		expectedSetG.add("luiz");
		expectedSetG.add("lugw");
		Set<String> actualSetG = dict.signatureToWords("5849");
		assertEquals(expectedSetG, actualSetG,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");

		Set<String> expectedSetH = new TreeSet<String>();
		expectedSetH.add("a");
		expectedSetH.add("b");
		expectedSetH.add("c");
		Set<String> actualSetH = dict.signatureToWords("2");
		assertEquals(expectedSetH, actualSetH,
				"failure in treeDictionarySignatureToWordsTest: " + "expected set does not match actual set");
	}

	@Test
	public void trimTest() {
		
		Set<String> InputSetA = new TreeSet<String>();
		Set<String> expectedSetA = new TreeSet<String>();
		assertEquals(expectedSetA, TreeDictionary.trim(InputSetA, 2),
				"failure in trimTest: " + "expected set does not match actual set");

		Set<String> InputSetB = new TreeSet<String>();
		InputSetB.add("hello");
		InputSetB.add("abcdefghij");
		Set<String> expectedSetB = new TreeSet<String>();
		expectedSetB.add("he");
		expectedSetB.add("ab");
		assertEquals(expectedSetB, TreeDictionary.trim(InputSetB, 2),
				"failure in trimTest: " + "expected set does not match actual set");
		
		Set<String> InputSetC = new TreeSet<String>();
		InputSetC.add("hello");
		InputSetC.add("abc");
		Set<String> expectedSetC = new TreeSet<String>();
		expectedSetC.add("hello");
		expectedSetC.add("abc");
		assertEquals(expectedSetC, TreeDictionary.trim(InputSetC, 5),
				"failure in trimTest: " + "expected set does not match actual set");

	}

}
