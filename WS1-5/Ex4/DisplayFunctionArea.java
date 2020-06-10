import java.util.function.Function;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

/**
 * Debugging: <br>
 * <br>
 * The first issue with the code is that the values of min and max, which are
 * used in the method drawXAxis, are not initialised. A method getMaxMin was
 * created to get the values of max and min which will be used throughout the
 * class. The values are obtained by going through a loop and comparing the
 * current y value with the previous y value and storing it in min or max if
 * it's higher or lower. <br>
 * <br>
 * The second issue is with drawYAxis, as it is not drawing the Y axis at the
 * correct location. The problem is in the x-coordinate, which should be equal
 * to the absolute value of "a" times the width of the panel, X_SIZE, when a is
 * less than 0. <br>
 * <br>
 * The third issue is with functionToPolyline. Here the x-coordinates have to be
 * set to i * X_SIZE / n in order to scale appropriately with n. the y-
 * coordinates need to be equal to: <br>
 * max * Y_SIZE / (max - min) - (Y_SIZE / (max - min) * y), which is the x-axis
 * minus (Y_SIZE / (max - min) * y), giving the correct coordinate. <br>
 * <br>
 * The final issue is with functionToPolygon, where the x and y coordinates are
 * corrected to be set the same way as in functionToPolyline. In addition to
 * this, the last two points for the polygon have to be set in order to fill in
 * the colour of the polygon correctly. These are set to a point that lies at
 * the end of the x-axis and a point that lies at the start of the x-axis. <br>
 * <br>
 * 
 * 
 * This class is to display a non-constant function such as x goes to x*x and
 * the area between the function graph and the x-axis in a given interval [a,b].
 * It is done by drawing the x-axis and the y-axis as well as defining a
 * polyline from the function, the end-point (b, f(b)) and the starting point at
 * (a, f(a)) and then displaying the corresponding polygon filled with colour
 * and adequately scaled.
 * 
 * @author Ignas Stakaitis (originally Manfred Kerber)
 * @version 01/12/2019 (originally 17/11/2019)
 * 
 */
public class DisplayFunctionArea extends Application {
	/**
	 * X_SIZE is the width of the panel in pixels. Set to 600.
	 */
	public static final int X_SIZE = 600;
	/**
	 * Y_SIZE the height of the panel in pixels. Set to 600.
	 */
	public static final int Y_SIZE = 600;
	/**
	 * f is the function to be displayed. We introduce it as a global variable so
	 * that it can be used in the start method, but be defined in the main method.
	 */
	private static Function<Double, Double> f;
	/**
	 * a is the left border of the interval on which the function is to be
	 * displayed. We introduce it as a global variable so that it can be used in the
	 * start method, but be defined in the main method.
	 */
	private static double a;
	/**
	 * b is the right border of the interval on which the function is to be
	 * displayed. We introduce it as a global variable so that it can be used in the
	 * start method, but be defined in the main method.
	 */
	private static double b;
	/**
	 * n is the granularity. More concretely, the interval [a,b] will be subdivided
	 * in n parts and on each the function will be approximated by a straight line.
	 */
	private static int n;
	/**
	 * max is an approximation of the maximum of f in the interval [a,b]. It is
	 * introduced as a global variable so that it does not have to be recomputed.
	 */
	private static double max;
	/**
	 * min is an approximation of the minimum of f in the interval [a,b]. It is
	 * introduced as a global variable so that it does not have to be recomputed.
	 */
	private static double min;
	/**
	 * The polyline will be the approximation of the function and be displayed.
	 */
	private static Polyline polyline;
	/**
	 * The polygon will be the area between the function and the x-axis.
	 */
	private static Polygon polygon;
	/**
	 * The colour in which the area is displayed.
	 */
	public static Color areaColour = Color.YELLOW;

	/**
	 * The method getMaxMin calculates the values of max and min.
	 * 
	 * @param f The function to be drawn.
	 */
	public static void getMaxMin(Function<Double, Double> f) {
		double x, y;
		min = 0;
		max = 0;
		for (int i = 0; i <= n; i++) {
			x = a + (b - a) * i / n;
			y = f.apply(x);
			if (y < min) {
				min = y;
			} else if (y > max) {
				max = y;
			}
		}
	}

	/**
	 * The method generates a polygon corresponding to the area between the function
	 * f and the x-axis in the interval [a,b].
	 * 
	 * @param f The function to be drawn.
	 * @param n The number of equidistant intervals to be drawn.
	 * @param a The minimal x-value in the interval.
	 * @param b The maximal x-value in the interval.
	 * @return The polygon corresponding to the area between the function f and the
	 *         x-axis over the interval [a,b] with granularity n.
	 */
	public static Polygon functionToPolygon(Function<Double, Double> f, int n, double a, double b) {
		if (a >= b) {
			throw new IllegalArgumentException();
		} else {
			double[] points = new double[2 * (n + 1) + 4];
			double x, y;
			/*
			 * Loop: Add x and y values to the corresponding arrays for a, b and n-1
			 * equidistant values in between. The (x_i,y_i) values are added to the points
			 * array in pairs.
			 */
			for (int i = 0; i <= n; i++) {
				x = a + (b - a) * i / n;
				y = f.apply(x);
				points[2 * i] = i * X_SIZE / n;
				points[2 * i + 1] = max * Y_SIZE / (max - min) - (Y_SIZE / (max - min) * y);
			}
			points[2 * (n + 1)] = Y_SIZE;
			points[2 * (n + 1) + 1] = max * Y_SIZE / (max - min);
			points[2 * (n + 1) + 2] = 0;
			points[2 * (n + 1) + 3] = max * Y_SIZE / (max - min);
			/* Draw graph */
			return new Polygon(points);
		}
	}

	/**
	 * The method generates a polyline corresponding to the graph of function f in
	 * the interval [a,b]
	 * 
	 * @param f The function to be drawn.
	 * @param n The number of equidistant intervals to be drawn.
	 * @param a The minimal x-value in the interval.
	 * @param b The maximal x-value in the interval.
	 * @return The polyline corresponding to the function f over the interval [a,b]
	 *         with granularity n.
	 */
	public static Polyline functionToPolyline(Function<Double, Double> f, int n, double a, double b) {
		if (a >= b) {
			throw new IllegalArgumentException();
		} else {
			double[] points = new double[2 * (n + 1)];
			double x, y;
			/*
			 * Loop: Add x and y values to the corresponding arrays for a, b and n-1
			 * equidistant values in between. The (x_i,y_i) values are added to the points
			 * array in pairs.
			 */
			for (int i = 0; i <= n; i++) {
				x = a + (b - a) * i / n;
				y = f.apply(x);
				points[2 * i] = i * X_SIZE / n;
				points[2 * i + 1] = max * Y_SIZE / (max - min) - (Y_SIZE / (max - min) * y);
			}
			/*
			 * Draw graph
			 */
			Polyline result = new Polyline(points);
			result.setStrokeWidth(3);
			return result;
		}
	}

	/**
	 * The method draws the x-axis if 0 is in the interval ]min,max[. It is assumed
	 * that the function is not constant.
	 * 
	 * @param root The group to which the x-axis is to be added.
	 */
	public static void drawXAxis(Group root) {
		if (min < 0 && 0 < max) {
			Line line = new Line(0, max * Y_SIZE / (max - min), X_SIZE, max * Y_SIZE / (max - min));
			line.setStrokeWidth(2);
			root.getChildren().add(line);
		}
	}

	/**
	 * The method draws the y-axis if 0 is in the interval ]a, b[.
	 * 
	 * @param root The group to which the y-axis is to be added.
	 */
	public static void drawYAxis(Group root) {
		if (a < 0 && 0 < b) {
			Line line = new Line((Math.abs(a)) * X_SIZE / (b - a), 0, (Math.abs(a)) * X_SIZE / (b - a), Y_SIZE);
			line.setStrokeWidth(2);
			root.getChildren().add(line);
		}
	}

	/**
	 * @param stage The window to be displayed.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// Create a Group (scene graph) with the line as single element.
		Group root = new Group();
		root.getChildren().add(polyline);
		root.getChildren().add(polygon);
		drawXAxis(root);
		drawYAxis(root);

		// The scene consists of just one group.
		Scene scene = new Scene(root, X_SIZE, Y_SIZE);
		// Give the stage (window) a title and add the scene.
		stage.setTitle("Function Graph");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * The method gives values to the static variables a, b, n and polyline.
	 * 
	 * @param f              The function to be displayed.
	 * @param numberOfValues The number of points on the polyline.
	 * @param left           The left border of the interval to be displayed.
	 * @param right          The right border of the interval to be displayed.
	 */
	public static void displayFunctionArea(Function<Double, Double> f, double left, double right, int numberOfValues) {
		a = left;
		b = right;
		n = numberOfValues;
		getMaxMin(f);
		polyline = functionToPolyline(f, numberOfValues, left, right);
		polygon = functionToPolygon(f, numberOfValues, left, right);
		polygon.setFill(areaColour);
	}

	/**
	 * main method to launch the application.
	 */
	public static void main(String[] args) {
		displayFunctionArea(x -> x * x * x - 8 * x * x, -2, 9, 500);
		launch(args);
	}
}