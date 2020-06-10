package predictive;

/**
 * This class contains a command line program for converting signatures to
 * words, using the ListDictionary class.
 * 
 * <p>
 * Sigs2WordsList vs Sigs2WordsMap vs Sigs2WordsTree time comparison <br>
 * <br>
 * Input = 100 signatures <br>
 * Sigs2WordsList time = 0m1.109s <br>
 * Sigs2WordsMap time = 0m1.285s <br>
 * Sigs2WordsTree time = 0m3.411s <br>
 * <br>
 * Input = 1000 signatures <br>
 * Sigs2WordsList time = 0m1.129s <br>
 * Sigs2WordsMap time = 0m1.342s <br>
 * Sigs2WordsTree time = 0m3.389s <br>
 * <br>
 * Input = 10000 signatures <br>
 * Sigs2WordsList time = 0m1.235s <br>
 * Sigs2WordsMap time = 0m1.430s<br>
 * Sigs2WordsTree time = 0m3.335s <br>
 * <br>
 * Building the list, map and tree from the dictionary is what takes the most
 * amount of time, therefore increasing the number of arguments does not greatly
 * affect the time taken to run the program. A bigger difference could perhaps
 * be seen if an even larger dictionary was used.
 * </p>
 * 
 * @author Ignas Stakaitis
 *
 */
public class Sigs2WordsTree {
	/**
	 * This method prints out the matching words for the signatures which have been
	 * input.
	 * 
	 * @param args An array containing the command line input.
	 */
	public static void main(String[] args) {
		TreeDictionary dict = new TreeDictionary("/usr/share/dict/words");
		for (int i = 0; i < args.length; i++) {
			String space = "";
			if (args[i].matches("[2-9]+")) {
				System.out.print(args[i] + ": ");
				for (String element : dict.signatureToWords(args[i])) {
					System.out.print(space + element);
					space = " ";
				}
				System.out.println("");
			}
		}
	}
}
