package predictive;

/**
 * This class pairs words with numeric signatures, which allows the creation of
 * an ArrayList in the ListDictionary class which contains words and their
 * associated signatures.
 * 
 * @author Ignas Stakaitis
 *
 */
public class WordSig implements Comparable<WordSig> {
	/**
	 * This string represents a word related to a certain signature.
	 */
	private String words;
	/**
	 * This string contains a numeric input which corresponds to certain words.
	 */
	private String signature;

	/**
	 * A constructor for the WordSig class.
	 * 
	 * @param words     A string containing a word which matches a certain
	 *                  signature.
	 * @param signature A string containing the numeric digits which match certain
	 *                  words.
	 */
	public WordSig(String words, String signature) {
		this.words = words;
		this.signature = signature;
	}

	/**
	 * A getter for the word.
	 * 
	 * @return the word
	 */
	public String getWords() {
		return words;
	}

	/**
	 * A getter for the signature.
	 * 
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * This method compares the signatures in WordSig by returning positive if
	 * this.signature is larger than ws.signature, negative if this.signature is
	 * smaller and 0 if they are equal.
	 * 
	 * @param ws An element of type WordSig which contains a word and a signature.
	 * @return positive if greater, negative if lesser, 0 if equal.
	 */
	@Override
	public int compareTo(WordSig ws) {
		return this.getSignature().compareTo(ws.getSignature());
	}

}
