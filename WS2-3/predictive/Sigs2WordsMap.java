package predictive;

/**
 * This class contains a command line program for converting signatures to
 * words, using the MapDictionary class.
 * 
 * @author Ignas Stakaitis
 *
 */
public class Sigs2WordsMap {
	/**
	 * This method prints out the matching words for the signatures which have been
	 * input.
	 * 
	 * @param args An array containing the command line input.
	 */
	public static void main(String[] args) {
		MapDictionary dict = new MapDictionary("/usr/share/dict/words");
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
