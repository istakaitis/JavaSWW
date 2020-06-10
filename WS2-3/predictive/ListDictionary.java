package predictive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class contains a version of the predictive text application that reads
 * and stores the dictionary as a list of pairs.
 * 
 * @author Ignas Stakaitis
 *
 */
public class ListDictionary implements Dictionary {

	/**
	 * An ArrayList of type WordSig which stores pairs of words and their
	 * signatures.
	 */
	private ArrayList<WordSig> dictPair;

	/**
	 * The constructor for the ListDictionary class takes in a string which is the
	 * path to the dictionary file and adds pairs of strings (word and signature) to
	 * the WordSig type ArrayList dictPair.
	 * 
	 * @param path A string which is the path to the dictionary file.
	 */
	public ListDictionary(String path) {
		dictPair = new ArrayList<WordSig>();
		File file = new File(path);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine().toLowerCase();
				// if a word is valid, it is converted to lower case and added to the ArrayList
				// along with its signature as a pair
				if (PredictivePrototype.isValidWord(line)) {
					dictPair.add(new WordSig(line, PredictivePrototype.wordToSignature(line.toLowerCase())));
				}
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		// the ArrayList is sorted
		Collections.sort(dictPair);
	}

	/**
	 * A getter for the dictPair ArrayList.
	 * 
	 * @return the dictPair
	 */
	public ArrayList<WordSig> getDictPair() {
		return dictPair;
	}

	/**
	 * This method takes a signature and returns a set of words which correspond to
	 * the signature. This is achieved by searching the sorted ArrayList with the
	 * binarySearch method.
	 * 
	 * @param signature A string of numbers which correspond to words.
	 * @return a set of type String which contains words which correspond to the
	 *         signature.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		// only numeric signatures are considered
		Set<String> matchingWords = new TreeSet<String>();
		if (!signature.matches("[2-9]+")) {
			return matchingWords;
		}
		WordSig key = new WordSig("", signature);
		// binary search returns index
		int index = Collections.binarySearch(this.getDictPair(), key);
		// if not in dictionary, returns empty set
		if (index <= -1) {
			return matchingWords;
		}

		int indexHigher = index;
		int indexLower = index;
		String sigHigher = this.getDictPair().get(indexHigher).getSignature();
		String sigLower = this.getDictPair().get(indexLower).getSignature();

		// searches through higher indices in the set and ArrayList and adds words which
		// have the same signature
		while (sigHigher.equals(signature) && indexHigher < dictPair.size()) {
			matchingWords.add(this.getDictPair().get(indexHigher).getWords());
			indexHigher++;
			sigHigher = this.getDictPair().get(indexHigher).getSignature();
		}
		// searches through lower indices in the set and ArrayList and adds words which
		// have the same signature
		while (sigLower.equals(signature) && indexLower > 0) {
			matchingWords.add(this.getDictPair().get(indexLower).getWords());
			indexLower--;
			sigLower = this.getDictPair().get(indexLower).getSignature();
		}
		return matchingWords;
	}

}
