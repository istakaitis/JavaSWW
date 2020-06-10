import java.util.*;
import java.util.regex.Pattern;

/**
 * The first problem with the original file is the the file name is
 * Counting.java (as stated in the work sheet), whereas the class is called
 * Counter. The class name must match the file name. The file name is therefore
 * changed to Counter.java and as a result, the constructor and the parcels
 * object in the main method are created with the correct naming.<br>
 * <br>
 * The are problems with the switch statement. Firstly, there needs to be a
 * break after every case.<br>
 * <br>
 * Secondly, the default statement should not throw an exception if the aim of
 * the program is to keep running when unexpected inputs occur. This is changed
 * to a print statement reminding the user of the possible inputs.<br>
 * <br>
 * Thirdly, the while loop must contain a try and catch block in order to keep
 * the program running when an integer that is not between 1 and 5 is inputed,
 * or when the input is not an integer at all. <br>
 * <br>
 * The program now runs as expected.
 * 
 * 
 * @author Ignas Stakaitis (originally by Manfred Kerber and Alexandros
 *         Evangelidis)
 * @version 30/10/2019
 *
 */
public class Counter {
	/**
	 * Pattern for the choice of input: either 1, 2, 3, 4, or 5
	 */
	public static final Pattern p12345 = Pattern.compile("[12345]");
	/**
	 * Field variable to store the value of the counter.
	 */
	private int counter;

	/**
	 * The constructor initialises the counter as 0. Starts a scanner to read from
	 * the command line, offering 5 choices for (add, subtract, show counter, set
	 * counter, and exit). It stays in a loop until the program is explicitly exited
	 * by entering 5. It has no parameters.
	 */
	public Counter() {
		this.counter = 0;
		// System.in is like System.out, however, for input and not for output.
		Scanner s = new Scanner(System.in);
		/*
		 * can take value 1 (add)
		 *
		 * 2 (subtract)
		 *
		 * 3 (show counter)
		 *
		 * 4 (set counter)
		 *
		 * 5 (exit)
		 */
		byte topChoice = 1; // Can be anything but 5 to enter the loop
		while (topChoice != 5) {
			System.out.println("Please enter:\n" + "1 to add to the total\n" + "2 to subtract from the total\n"
					+ "3 to show the total\n" + "4 to set the total\n" + "5 to exit the program");
			try {

				topChoice = (byte) Integer.parseInt(s.next(p12345));
				switch (topChoice) {
				case 1:
					add(s);
					break;
				case 2:
					subtract(s);
					break;
				case 3:
					show();
					break;
				case 4:
					set(s);
					break;
				case 5:
					System.out.println("Finally there are " + counter + " items available.");
					break;
				default:
					System.out.println("You must enter an integer 1-5.");
					break;
				}
			}

			catch (InputMismatchException e) {
				System.out.println("You must enter an integer 1-5.");
				s = new Scanner(System.in);
			}
		}
	}

	/**
	 * The method reads in a number from the input and adds it to the counter.
	 * 
	 * @param s The scanner from which the input is read.
	 */
	public void add(Scanner s) {
		System.out.println("How much to add?");
		try {
			counter += Integer.parseInt(s.next());
		} catch (NumberFormatException e) {
			System.out.println("You need to enter an integer.");
			s = new Scanner(System.in);
		}
	}

	/**
	 * The method reads in a number from the input and subtracts it from the
	 * counter.
	 * 
	 * @param s The scanner from which the input is read.
	 */
	public void subtract(Scanner s) {
		System.out.println("How much to subtract?");
		try {
			counter -= Integer.parseInt(s.next());
		} catch (NumberFormatException e) {
			System.out.println("You need to enter an integer.");
			s = new Scanner(System.in);
		}
	}

	/**
	 * The method prints the current value of the counter.
	 */
	public void show() {
		System.out.println("Currently there are " + counter + " items available.");
	}

	/**
	 * The method reads in a number from the input and sets the counter to this
	 * value
	 * 
	 * @param s The scanner from which the input is read.
	 */
	public void set(Scanner s) {
		System.out.println("To which value do you want to set the counter?");
		try {
			counter = Integer.parseInt(s.next());
		} catch (NumberFormatException e) {
			System.out.println("You need to enter an integer.");
			s = new Scanner(System.in);
		}
	}

	/**
	 * Main method now called with correct class name
	 */
	public static void main(String[] args) {
		Counter parcels = new Counter();
	}
}