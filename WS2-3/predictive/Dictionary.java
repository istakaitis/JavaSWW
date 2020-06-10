package predictive;

import java.util.Set;

/**
 * This is the Dictionary interface for the predictive package, which includes
 * the signatureToWords method.
 * 
 * @author Ignas Stakaitis
 *
 */
public interface Dictionary {
	
	/**
	 * This method takes a signature and returns a set of words which correspond to
	 * the signature.
	 * 
	 * @param signature A string of numbers which correspond to words.
	 * @return a set of type String which contains words which correspond to the
	 *         signature.
	 */
	public Set<String> signatureToWords(String signature);
}
