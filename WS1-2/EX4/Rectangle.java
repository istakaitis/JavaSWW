/**
 * 
 * There are a few problems with the original code. <br>
 * <br>
 * Firstly, the Javadoc comment for the constructor states that the perimeter of
 * the rectangle is two times the width plus the height. This is incorrect, as
 * the perimeter is actually defined as two times the width plus two times the
 * height. Secondly, the perimeter shouldn't be initialised at all, as it can
 * simply be calculated from knowing the height and the width. Furthermore,
 * there is a setter for perimeter, which shouldn't exist, as the perimeter has
 * to be directly calculated from the width and height only. <br>
 * <br>
 * The code is debugged by the removal of the field variable perimeter and its
 * associated setter (the getter is replaced with the calculatePerimeter method,
 * which calculates and returns the perimeter with respect to the width and
 * height of the rectangle. It is then tested in the main method, giving the
 * expected results.
 * 
 * @author Ignas Stakaitis
 * @version 19/10/2019
 *
 */
public class Rectangle {
	private double width;
	private double height;

	/**
	 * The constructor Rectangle initialises the width and height of the rectangle.
	 * These parameters are both doubles.
	 * 
	 * @param width  the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * getWidth is a getter method for the width.
	 * 
	 * @return The width of the rectangle is returned.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * getHeight is a getter method for the height.
	 * 
	 * @return The height of the rectangle is returned.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * setWidth is a setter method for the width.
	 * 
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * setHeight is a setter method for the height.
	 * 
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * calculatePerimeter multiplies the width times two and adds it to the height
	 * times two.
	 * 
	 * @return The perimeter of the rectangle is returned.
	 */
	public double calculatePerimeter() {
		return this.height * 2 + this.width * 2;
	}

	/**
	 * The toString method prints the height, width and resulting perimeter of a
	 * rectangle.
	 * 
	 * @return A human readable description of the rectangle in form of the two
	 *         field variables specifying it and the calculated perimeter.
	 */
	public String toString() {
		return "The rectangle has a width of " + width + ", a height of " + height + ", and a perimeter of "
				+ this.calculatePerimeter() + ".";
	}

	/**
	 * A main method which creates a Rectangle object, calls the toString method,
	 * then calls setHeight and calls toString again to print the resulting
	 * information about the rectangle.
	 * 
	 */
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 4);
		System.out.println(r);
		r.setHeight(5);
		System.out.println(r);
	}
}
