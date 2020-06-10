import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The class Pie produces a JavaFX scene which displays a pie chart to the user.
 * The pie chart shows the expenditures associated with a company.
 * 
 * @author Ignas Stakaitis
 * @version 01/12/2019
 */
public class Pie extends Application {

	/**
	 * X_SIZE is the width of the panel in pixels. It is set to 800.
	 */
	private static final int X_SIZE = 800;
	/**
	 * Y_SIZE is the height of the panel in pixels. It is set to 500.
	 */
	private static final int Y_SIZE = 500;
	/**
	 * X_CENTRE is the x-coordinate of the centre of the panel. It is set to half of
	 * X_SIZE.
	 */
	private static final int X_CENTRE = X_SIZE / 2;
	/**
	 * Y_CENTRE is the y-coordinate of the centre of the panel. It is set to half of
	 * Y_SIZE.
	 */
	private static final int Y_CENTRE = Y_SIZE / 2;
	/**
	 * RADIUS is the radius of the pie chart. It is set to a sixth of X_SIZE.
	 */
	private static final int RADIUS = X_SIZE / 6;
	/**
	 * expenditures is an array of objects of class Expenditure. The company
	 * expenditures are represented in the pie chart.
	 */
	private static Expenditure[] expenditures;
	/**
	 * maximum is the number of items the user wants displayed in the pie chart.
	 */
	private static int maximum;

	/**
	 * The method sort is used to arrange the expenditures array in descending order
	 * of expenditure values.
	 * 
	 * @param expenditures An array of company expenditures.
	 */
	public static void sort(Expenditure[] expenditures) {
		Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) -> exp2.getValue() - exp1.getValue());
	}

	/**
	 * The method checkMaximum sets the maximum equal to the length of the
	 * expenditures array in cases when maximum is set to a negative number or
	 * greater than the length of the expenditures array.
	 */
	public static void checkMaximum() {
		if (maximum > expenditures.length || maximum < 0) {
			maximum = expenditures.length;
		}
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
	 * The method expendituresNormalised converts the expenditures to radians.
	 * 
	 * @param expenditures An array of company expenditures.
	 * @param maximum      The maximum items to be displayed in the pie chart.
	 * @return An array of doubles which contains the angles for the pie chart.
	 */
	public static double[] expendituresNormalised(Expenditure[] expenditures, int maximum) {
		// extra index for setting last index to 0.
		double[] angles = new double[maximum + 1];
		// 0th index set to 2 * pi
		angles[0] = 2 * Math.PI;
		double previousValue = 2 * Math.PI;
		// loop adds the values in radians to an array.
		for (int i = 1; i < angles.length; i++) {
			angles[i] = previousValue
					- (2 * Math.PI) * ((double) expenditures[i - 1].getValue() / totalExpenditure(expenditures));
			previousValue = angles[i];
		}
		angles[maximum] = 0;
		return angles;

	}

	/**
	 * The method drawCircle creates a single Circle to be used for the pie chart.
	 * 
	 * @return A Circle for the pie chart.
	 */
	private static Circle drawCircle() {
		Circle pieChartCircle = new Circle(X_SIZE / 2, Y_SIZE / 2, RADIUS);
		pieChartCircle.setStroke(Color.BLACK);
		pieChartCircle.setFill(null);
		return pieChartCircle;
	}

	/**
	 * The method drawLines creates lines and adds them to an array. The lines are
	 * drawn from the values calculated in the expendituresNormalised method,
	 * starting from the centre of the circle and extending by the length of the
	 * radius.
	 * 
	 * @return An array of lines which will appear in the pie chart.
	 */
	public static Line[] drawLines() {
		double[] angles = expendituresNormalised(expenditures, maximum);
		Line[] lines = new Line[maximum];
		// loop creates lines from the centre to the appropriate point, depending on the
		// angle, which is obtained from the method expendituresNormalised.
		for (int i = 0; i < lines.length; i++) {
			lines[i] = new Line(X_CENTRE, Y_CENTRE, X_CENTRE + RADIUS * Math.cos(angles[i]),
					Y_CENTRE + RADIUS * Math.sin(angles[i]));
		}
		// no lines needed if maximum is 1 or 0 less
		if (maximum <= 1) {
			lines = new Line[0];
		}
		return lines;
	}

	/**
	 * The method createText creates text and adds it to an array. The text contains
	 * the description of the company's expenditures.
	 * 
	 * @return an array of text containing the descriptions for the expenditures.
	 */
	public static Text[] createText() {
		// initialising text array.
		Text[] text = new Text[maximum];
		// returning empty array if maximum is 0.
		if (maximum == 0) {
			return text;
		}
		// creating an array of text.
		for (int i = 0; i < text.length; i++) {
			text[i] = new Text(expenditures[i].getDescription());
		}
		// final element set to "Other".
		text[maximum - 1].setText("Other");
		return text;
	}

	/**
	 * The method textCentreHeight finds the height of text, divides that by two to
	 * get half of the height, and adds it to an array.
	 * 
	 * @return An array which contains the distance from the bottom of the text to
	 *         it's centre.
	 */
	public static double[] textCentreHeight() {
		Text[] text = createText();
		double[] textCentreHeight = new double[text.length];
		for (int i = 0; i < text.length; i++) {
			textCentreHeight[i] = text[i].getLayoutBounds().getHeight() / 2;
		}
		return textCentreHeight;
	}

	/**
	 * The method textCentreWidth find the width of text, divides that by two to get
	 * half of the width. and adds it to an array.
	 * 
	 * @return An array which contains the distance from the start of the text to
	 *         it's centre.
	 */
	public static double[] textCentreWidth() {
		Text[] text = createText();
		double[] textCentreWidth = new double[text.length];
		for (int i = 0; i < text.length; i++) {
			textCentreWidth[i] = text[i].getLayoutBounds().getWidth() / 2;
		}
		return textCentreWidth;
	}

	/**
	 * The method drawText takes the text array from the createText method and
	 * assigns coordinates to the descriptions of the expenditures and.
	 * 
	 * @return An array of text which contains descriptions of the expenditures with
	 *         coordinates.
	 */
	public static Text[] drawText() {
		Text[] text = createText();
		double[] angles = expendituresNormalised(expenditures, maximum);
		double[] textHeight = textCentreHeight();
		double[] textWidth = textCentreWidth();
		// loop sets x and y coordinates for the items in the text array
		for (int i = 0; i < text.length; i++) {
			double xAngle = Math.cos(angles[i] + (angles[i + 1] - angles[i]) / 2);
			double yAngle = Math.sin(angles[i] + (angles[i + 1] - angles[i]) / 2);
			double xOffset = textWidth[i] + X_SIZE / 30;
			double xPosition = X_CENTRE + (RADIUS + xOffset) * xAngle - textWidth[i];
			double yOffset = textHeight[i] + X_SIZE / 30;
			double yPosition = Y_CENTRE + (RADIUS + yOffset) * yAngle + textHeight[i];
			text[i].setX(xPosition);
			text[i].setY(yPosition);
		}
		return text;
	}

	/**
	 * The start method. The pie chart circle, lines and descriptions of
	 * expenditures are added to the group. Subsequently, the group is added to the
	 * scene.
	 * 
	 * @param stage The window to be displayed.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		checkMaximum();
		sort(expenditures);
		Line[] pieChartLines = drawLines();
		Text[] pieChartText = drawText();

		Group root = new Group();
		root.getChildren().add(drawCircle());

		for (int i = 0; i < pieChartLines.length; i++) {
			root.getChildren().add(pieChartLines[i]);
		}

		for (int i = 0; i < pieChartText.length; i++) {
			root.getChildren().add(pieChartText[i]);
		}

		Scene scene = new Scene(root, X_SIZE, Y_SIZE);
		stage.setTitle("Expenditures");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * The main method is used to launch the application. Expenditures must be added
	 * to the expenditure array and a maximum number of elements to be displayed in
	 * the pie chart must be set.
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
