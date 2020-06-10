/**
 * This class takes a given time and returns the anti-clockwise angle between
 * the hour hand and the minute hand
 * 
 * @author Ignas Stakaitis
 * @version 04/10/2019
 */
public class EX3 {

	/**
	 * 
	 * @param hours,   time in hours
	 * @param minutes, time in minutes
	 * @param seconds, time in seconds
	 * @return the anti-clockwise angle between the hour and minute hands
	 */
	public static int timeToAngle(int hours, int minutes, double seconds) {
		// conversion of hours to 12 hour format
		int convertedHours = hours % 12;

		// angle of the hour hand from 12 o'clock, including movement due to minute hand
		double hourAngle = (convertedHours * 30) + (minutes * 0.5);

		// angle of minute hand from 12 o'clock, including movement due to second hand
		double minuteAngle = (minutes * 6) + (seconds * 0.1);

		// if hour hand is further than minute hand, the anti-clockwise angle is found
		// by simple subtraction
		int finalAngle = (int) (hourAngle - minuteAngle);

		// if minute hand is further, 360 degrees are added and the remainder from
		// dividing by 360 is taken to prevent negative angles
		int result = (360 + finalAngle) % 360;
		return result;
	}

	public static void main(String[] args) {
		// testing timeToAngle at different times
		System.out.println(timeToAngle(9, 0, 0));
		System.out.println(timeToAngle(3, 0, 0));
		System.out.println(timeToAngle(18, 0, 0));
		System.out.println(timeToAngle(1, 0, 0));
		System.out.println(timeToAngle(2, 30, 0));
		System.out.println(timeToAngle(4, 41, 0));
		System.out.println(timeToAngle(0, 0, 20));
		System.out.println(timeToAngle(13, 5, 27.272727272727));
	}

}
