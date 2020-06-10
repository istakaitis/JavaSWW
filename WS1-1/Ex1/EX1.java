/**
 * This class takes a radius of a circle and returns the area of the circle.
 * 
 * @author Ignas Stakaitis
 * @version 04/10/2019
 */

public class EX1 {
	/**
	 * @param radius, the radius of a circle
	 * @return area of the circle
	 */
	public static double areaCircle(double radius) {
		return Math.PI * radius * radius;
	}

	public static void main(String[] args) {
		// testing areaCircle for radii of 0, 5 and 10
		System.out.println(areaCircle(0));
		System.out.println(areaCircle(5));
		System.out.println(areaCircle(10));

	}

}
