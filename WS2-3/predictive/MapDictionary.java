package predictive;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This class contains an improved implementation of the Dictionary interface
 * using a Map data structure.
 * 
 * A Map contains key and value pairs known as entries. For a known key, it is
 * simple to look up the associated values and it is not required to look at
 * neighbouring indices as in the List implementation, which makes the
 * MapDictionary an efficient and intuitive implementation.
 * 
 * @author Ignas Stakaitis
 *
 */
public class MapDictionary implements Dictionary {

	/**
	 * A map which contains a key, which is the signature and an associated set of
	 * words, which match the signature key which contains the dictionary
	 */
	private Map<String, Set<String>> dictMap;

	/**
	 * The constructor for the MapDictionary class takes in a string which is the
	 * path to the dictionary file and adds keys (signatures) and associated words
	 * to a Map.
	 * 
	 * @param path A string which is the path to the dictionary file.
	 */
	public MapDictionary(String path) {
		dictMap = new TreeMap<String, Set<String>>();
		File file = new File(path);

		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine().toLowerCase();
				String signature = PredictivePrototype.wordToSignature(line);
				if (PredictivePrototype.isValidWord(line)) {
					if (dictMap.containsKey(signature)) {
						// if signature already present as a key, add word to set
						dictMap.get(signature).add(line);
					} else {
						// otherwise, create new signature key and add word
						Set<String> words = new TreeSet<String>();
						words.add(line.toLowerCase());
						dictMap.put(signature, words);
					}
				}
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * This method takes a signature and returns a set of words which correspond to
	 * the signature by looking up a key in the map.
	 * 
	 * @param signature A string of numbers which correspond to words.
	 * @return a set of type String which contains words which correspond to the
	 *         signature.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		if (dictMap.containsKey(signature)) {
			return dictMap.get(signature);
		} else {
			return new TreeSet<String>();
		}

	}
}
