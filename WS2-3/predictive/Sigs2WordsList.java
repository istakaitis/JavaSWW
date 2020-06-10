package predictive;

/**
 * This class contains a command line program for converting signatures to
 * words, using the ListDictionary class.
 * 
 * <p>
 * Sigs2WordsProto vs Sigs2WordsList time comparison <br>
 * <br>
 * Input = 10 signatures <br>
 * Sigs2WordsProto time = 0m2.464s <br>
 * Sigs2WordsList time = 0m1.124s <br>
 * <br>
 * Input = 50 signatures <br>
 * Sigs2WordsProto time = 0m10.223s <br>
 * Sigs2WordsList time = 0m1.111s <br>
 * <br>
 * Input = 100 signatures <br>
 * Sigs2WordsProto time = 0m21.289s <br>
 * Sigs2WordsList time = 0m1.078s <br>
 * <br>
 * Sigs2WordsList is clearly faster.
 * </p>
 * 
 * @author Ignas Stakaitis
 *
 */
public class Sigs2WordsList {

	/**
	 * This method prints out the matching words for the signatures which have been
	 * input.
	 * 
	 * @param args An array containing the command line input.
	 */
	public static void main(String[] args) {
		ListDictionary dict = new ListDictionary("/usr/share/dict/words");
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
