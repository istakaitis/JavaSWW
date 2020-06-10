import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;

/**
 * The class Waffle produces a JavaFX scene which displays a waffle chart to the
 * user. The waffle chart shows the expenditures associated with a company.
 * 
 * @author Ignas Stakaitis
 * @version 01/12/2019
 */
public class Waffle extends Application {
	/**
	 * X_SIZE is the width of the panel in pixels. It is set to 650.
	 */
	private static final int X_SIZE = 650;
	/**
	 * Y_SIZE is the height of the panel in pixels. It is set to 325.
	 */
	private static final int Y_SIZE = 325;
	/**
	 * SQUARE_SIZE is the length in pixels of the side of a single square in the
	 * waffle chart. It is set to 25.
	 */
	private static final int SQUARE_SIZE = 25;
	/**
	 * OFFSET is used to create spaces between the squares in the waffle chart. It
	 * is set to 5.
	 */
	private static final int OFFSET = 5;
	/**
	 * colours is an array of colours used to colour the waffle chart and the legend
	 * for the chart.
	 */
	private static Color[] colours;
	/**
	 * expenditures is an array of objects of class Expenditure. The company
	 * expenditures are represented in the waffle chart.
	 */
	private static Expenditure[] expenditures;
	/**
	 * maximum is the number of items the user wants displayed in the waffle chart.
	 */
	private static int maximum;

	/**
	 * The method sort is used to arrange the expenditures array in descending order
	 * of expenditure values.
	 * 
	 * @param expenditures An array of company expenditures.
	 * 
	 */
	public static void sort(Expenditure[] expenditures) {
		Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) -> exp2.getValue() - exp1.getValue());
	}

	/**
	 * The method totalExpenditure calculates the total expenditure in the
	 * Expenditure array.
	 * 
	 * @param expenditures An array of company expenditures.
	 * @return The sum of the expenditures which is the total expenditure.
	 */
	public static int totalExpenditure(Expenditure[] expenditures) {
		int total = 0;
		for (int i = 0; i < expenditures.length; i++) {
			total += expenditures[i].getValue();
		}
		return total;
	}

	/**
	 * The method checkMaximum sets the maximum equal to the length of the
	 * expenditures array in cases when maximum is set to a number less than or
	 * equal to zero or greater than the length of the expenditures array.
	 */
	public static void checkMaximum() {
		if (maximum > expenditures.length || maximum <= 0) {
			maximum = expenditures.length;
		}
	}

	/**
	 * makeColourArray sets the colours in the colour array. The first 7 colours are
	 * set manually in order to closer represent the waffle chart used in the
	 * example. If maximum is greater than that, random colours are assigned to
	 * further elements in the array.
	 * 
	 * @param maximum The maximum items to be displayed in the Waffle chart.
	 * @return An array of type Color, which represents the colours that will appear
	 *         in the waffle chart.
	 */
	public static Color[] makeColourArray(int maximum) {
		colours = new Color[maximum];
		for (int i = 0; i < maximum; i++) {
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			switch (i) {
			case 0:
				colours[0] = Color.BLACK;
				break;
			case 1:
				colours[1] = Color.BLUE;
				break;
			case 2:
				colours[2] = Color.RED;
				break;
			case 3:
				colours[3] = Color.YELLOW;
				break;
			case 4:
				colours[4] = Color.GREEN;
				break;
			case 5:
				colours[5] = Color.BROWN;
				break;
			case 6:
				colours[6] = Color.VIOLET;
				break;
			default:
				colours[i] = Color.rgb(r, g, b);
			}
		}
		return colours;
	}

	/**
	 * The method numberOfSquares calculates the amount of squares each expenditure
	 * will have to take up in the waffle chart and places these values in an array
	 * of integers.
	 * 
	 * @param expenditures expenditures An array of company expenditures.
	 * @return An array which contains the number of squares each expenditure will
	 *         have to take up in the waffle chart.
	 */
	public static int[] numberOfSquares(Expenditure[] expenditures) {
		// the array which will contain the number of squares each expenditure has to
		// take up is initialised.
		int[] finalSquares = new int[expenditures.length];
		// the array which contains the remainders for each expenditure is initialised.
		int[] remainders = new int[expenditures.length];
		// a counter for the total amount of squares is initialised.
		double doubleTotalSquares = 0;
		// the number of squares a particular expenditure will have to take up is stored
		// here temporarily.
		double initialSquares = 0;
		// the remainder for a particular expenditure is stored here temporarily.
		int initialRemainder = 0;
		// the loop adds items to the to the arrays of finalSquares and remainders.
		for (int i = 0; i < expenditures.length; i++) {
			initialSquares = (double) expenditures[i].getValue() * 100 / totalExpenditure(expenditures);
			doubleTotalSquares += Math.round(initialSquares);
			finalSquares[i] = (int) Math.round(initialSquares);
			initialRemainder = (expenditures[i].getValue() * 100) % (totalExpenditure(expenditures));
			// if the division results in a value that will be rounded up, the remainder is
			// set to 0.
			if (initialRemainder > (totalExpenditure(expenditures) / 2)) {
				remainders[i] = 0;
			} else {
				remainders[i] = initialRemainder;
			}
		}
		// the amount of squares that have been counted.
		int totalSquares = (int) doubleTotalSquares;
		// the largest remainder is initialised.
		int maxRemainder = remainders[0];
		// the index of the largest remainder is initialised.
		int maxRemainderIndex = 0;
		// the squares required for each expenditure with the highest remainder are
		// incremented until the total amount of squares counted reaches 100.
		while (totalSquares < 100) {
			for (int i = 0; i < remainders.length; i++) {
				if (remainders[i] > maxRemainder) {
					maxRemainder = remainders[i];
					maxRemainderIndex = i;
				}
			}
			finalSquares[maxRemainderIndex]++;
			remainders[maxRemainderIndex] = 0;
			maxRemainder = 0;
			totalSquares++;
		}
		return finalSquares;
	}

	/**
	 * The method makeSquares walks through the two dimensional rectangle array and
	 * assigns each index a square with the colour determined by the colours array
	 * and the numberOfSquares method.
	 * 
	 * @return A two dimensional array of type Rectangle, which contains the squares
	 *         that will be used in the waffle chart.
	 */
	public static Rectangle[][] makeSquares() {
		// the amount of squares required for each expenditure is stored in the array of
		// integers howManySquares
		int[] howManySquares = numberOfSquares(expenditures);
		// an index is set to 0.
		int index = 0;
		// a count is set to the number of squares required for the 0th element of the
		// sorted expenditures.
		int count = howManySquares[index];
		// two dimensional array of squares is initialised.
		Rectangle[][] squares = new Rectangle[10][10];
		// the nested loop walks through the two dimensional array.
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				// if count is 0, index is incremented and count is set the the next index of
				// howManySquares
				if (count == 0) {
					index++;
					count = howManySquares[index];
				}
				// a new square is created
				squares[i][j] = new Rectangle(OFFSET + 1.25 * j * SQUARE_SIZE, OFFSET + 1.25 * i * SQUARE_SIZE,
						SQUARE_SIZE, SQUARE_SIZE);
				// the colour is set to cyan if the squares are supposed to represent the
				// "Other" expenditures. Otherwise, the appropriate colour in the colours array
				// is used. Subsequently, count is decremented.
				if (index >= (maximum - 1)) {
					squares[i][j].setFill(Color.CYAN);
				} else {
					squares[i][j].setFill(colours[index]);
				}
				count--;
			}
		}
		return squares;
	}

	/**
	 * The method legendSquareSize calculates the size of the squares to be used in
	 * the waffle chart legend. If the maximum is smaller than 8, the the size is
	 * kept constant, otherwise the squares would be too big.
	 * 
	 * @return The square size for the waffle chart legend.
	 */
	public static double legendSquareSize() {
		double size;
		if (maximum < 8) {
			size = SQUARE_SIZE * 5 / 8;
		} else {
			size = SQUARE_SIZE * 5 / maximum;
		}
		return size;

	}

	/**
	 * The method legendSquares adds the squares used in the legend to an array.
	 * 
	 * @return An array of Rectangles which contains the squares used in the waffle
	 *         chart legend.
	 */
	public static Rectangle[] legendSquares() {
		Rectangle[] legend = new Rectangle[maximum];
		double xPosition = X_SIZE / 1.5;
		double size = legendSquareSize();
		for (int i = 0; i < maximum; i++) {
			double yPosition = OFFSET + (Y_SIZE - size) / (maximum) * i;
			legend[i] = new Rectangle(xPosition, yPosition, size, size);
			if (i == maximum - 1) {
				legend[i].setFill(Color.CYAN);
			} else {
				legend[i].setFill(colours[i]);
			}
		}
		return legend;
	}

	/**
	 * The method legendText creates an array of type Text which stores the
	 * descriptions associated with expenditures. This array is used to represent
	 * the descriptions of expenditures in the waffle chart legend.
	 * 
	 * @return An array of Text which contains the descriptions of the expenditures.
	 */
	public static Text[] legendText() {
		double squareSize = legendSquareSize();
		Text[] legend = new Text[maximum];
		double xPosition = X_SIZE / 1.5 + squareSize + OFFSET;
		double size = 12;

		for (int i = 0; i < maximum; i++) {
			double yPosition = squareSize + (Y_SIZE - squareSize) / (maximum) * i;
			legend[i] = new Text(xPosition, yPosition, "");
			legend[i].setFont(new Font(size));
			if (i == maximum - 1) {
				legend[i].setText("Other");
			} else {
				legend[i].setText(expenditures[i].getDescription());
			}
		}
		return legend;
	}

	/**
	 * The start method. The waffle squares, legend squares and legend descriptions
	 * are added to the group. Subsequently, the group is added to the scene.
	 * 
	 * @param stage The window to be displayed.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// expenditures array is sorted
		sort(expenditures);
		// maximum is set to expenditures.length if it exceeds the length or is less
		// than or equal to 0.
		checkMaximum();
		makeColourArray(maximum);
		Group root = new Group();
		// adding the waffle squares to the group
		Rectangle[][] waffle = makeSquares();
		for (int i = 0; i < waffle.length; i++) {
			for (int j = 0; j < waffle[i].length; j++) {
				root.getChildren().add(waffle[i][j]);
			}
		}
		// adding the legend squares to the group
		Rectangle[] waffleLegendSquares = legendSquares();
		for (int i = 0; i < waffleLegendSquares.length; i++) {
			root.getChildren().add(waffleLegendSquares[i]);
		}
		// adding the legend text to the group
		Text[] waffleLegendText = legendText();
		for (int i = 0; i < waffleLegendText.length; i++) {
			root.getChildren().add(waffleLegendText[i]);
		}
		Scene scene = new Scene(root, X_SIZE, Y_SIZE);

		stage.setTitle("Expenditures");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * The main method is used to launch the application. Expenditures must be added
	 * to the expenditure array and a maximum number of elements to be displayed in
	 * the waffle chart must be set.
	 */
	public static void main(String[] args) {

		expenditures = new Expenditure[] { new Expenditure("Salaries", 11000), new Expenditure("Paper", 2000),
				new Expenditure("Rent", 5000), new Expenditure("Most popular books on Java etc.", 10000),
				new Expenditure("Heating", 3000), new Expenditure("Coffee/Tea", 7000),
				new Expenditure("Biscuits", 8000), new Expenditure("Travel", 18000),
				new Expenditure("Electricity", 1000), new Expenditure("Pencils", 3000) };

		maximum = 8;

		launch(args);
	}

}
