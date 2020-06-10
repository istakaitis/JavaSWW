package predictive;

/**
 * This class contains a command line program for converting words to
 * signatures.
 * 
 * @author Ignas Stakaitis
 */
public class Words2SigProto {
	/**
	 * This method prints out the matching signatures for the words which have been
	 * input.
	 * 
	 * @param args An array containing the command line input.
	 */
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + PredictivePrototype.wordToSignature(args[i]));
		}
	}

}
