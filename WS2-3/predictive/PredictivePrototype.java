package predictive;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is a prototype for the predictive text application, where the
 * signature is converted to words directly from the dictionary file.
 * 
 * @author Ignas Stakaitis
 *
 */
public class PredictivePrototype {

	/**
	 * This method takes a word and returns a numeric signature which corresponds to
	 * the numbers associated with the letter on an older model phone. Using the
	 * StringBuffer class rather than the String class is more efficient as the
	 * former is mutable. Using a String would require making new strings upon
	 * appending, rather than adding to the existing string.
	 * 
	 * @param word A string representing a word.
	 * @return A numeric signature representing a word.
	 */
	public static String wordToSignature(String word) {
		// the method only handles lower case letters
		word = word.toLowerCase();
		StringBuffer signature = new StringBuffer();
		int character;
		for (int i = 0; i < word.length(); i++) {
			character = word.charAt(i);
			if ((character >= 'a' && character <= 'r')) {
				// if the letter is between a and r, the ascii value is divided by 3 and 2 is
				// added to obtain the correct number on the phone pad.
				signature.append((character - 'a') / 3 + 2);
			} else if ((character >= 's' && character <= 'y')) {
				// if the letter is between s and y, an extra 1 has to be subtracted to account
				// for the offset of having 4 letter correspond to the digit 7.
				signature.append((character - 'a' - 1) / 3 + 2);
			} else if (character == 'z') {
				// the calculation is offset again by having 4 letters for the digit 9, so in
				// the case of z, 9 is added to the signature.
				signature.append(9);
			} else {
				// if the character is not a letter, a space is added.
				signature.append(" ");
			}
		}
		return signature.toString();
	}

	/**
	 * This method takes the given numeric signature and returns a set of possible
	 * matching words from the dictionary. Since it is a set there are no
	 * duplicates. The words returned are in lower case. The helper method
	 * isValidWord is used to check whether a line contains only alphabetic
	 * characters. This implementation is inefficient, as the dictionary will have
	 * to be read several times (once for each signature) and it is not stored in
	 * memory, therefore it cannot be sorted and it is impossible to use faster
	 * lookup techniques.
	 * 
	 * @param signature A string of numbers which represents potential words.
	 * @return a Set of type String which contains words matching the signature.
	 */
	public static Set<String> signatureToWords(String signature) {
		Set<String> matchingWords = new TreeSet<String>();
		File file = new File("/usr/share/dict/words");
		try {
			Scanner scan = new Scanner(file);
			// the loop runs while there are unread lines in the dictionary.
			while (scan.hasNextLine()) {
				String line = scan.nextLine().toLowerCase();
				if (isValidWord(line) && wordToSignature(line).equals(signature)) {
					matchingWords.add(line);
				}
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return matchingWords;
	}

	/**
	 * This method checks whether a string only contains alphabetic characters and
	 * returns true if that is the case. It returns false otherwise.
	 * 
	 * @param word A string representing a word
	 * @return true if the string only contains alphabetic characters, false
	 *         otherwise.
	 */
	static boolean isValidWord(String word) {
		return (word.matches("[A-Za-z]+"));
	}
}
