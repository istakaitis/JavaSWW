package predictive;

/**
 * This class contains a command line program for converting signatures to
 * words.
 * 
 * @author Ignas Stakaitis
 *
 */
public class Sigs2WordsProto {

	/**
	 * This method prints out the matching words for the signatures which have been
	 * input.
	 * 
	 * @param args An array containing the command line input.
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			String space = "";
			if (args[i].matches("[2-9]+")) {
				System.out.print(args[i] + ": ");
				for (String element : PredictivePrototype.signatureToWords(args[i])) {
					System.out.print(space + element);
					space = " ";
				}
				System.out.println("");
			}
		}
	}
}
