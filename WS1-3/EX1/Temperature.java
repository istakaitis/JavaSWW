/**
 * The class Temperature has one method, coldest, which returns the coldest day
 * of the year. For example, if the integer 1 is returned, this indicates that
 * the coldest day of the year is the 1st of January.
 * 
 * @author Ignas Stakaitis
 * @version 30/10/2019
 *
 */
public class Temperature {

	/**
	 * The method coldest takes as an argument an array of doubles, which represent
	 * temperatures on different days of the year and returns the day with the
	 * lowest temperature. In cases where the lowest temperature occurs more than
	 * once, the first occurrence of the temperature is returned <br><br>
	 * An integer variable coldestDay is initialised to 0.<br><br>
	 * The first (0) index of the temperature array is stored as the lowest
	 * temperature. <br><br>
	 * The method loops over the length of the array and in the case that the
	 * current item in the array is lower than the currently stored lowest
	 * temperature, the lowestTemperature variable is assigned the value of the
	 * current item in the array. Following that, the coldestDay variable is
	 * assigned the current index of the array.<br><br>
	 * Once the entire array has been looped through, 1 is added to the coldestDay
	 * variable because the array indices are lower than the corresponding day by
	 * one. coldestDay is returned.
	 * 
	 * @param temperatures an array which consists of the temperatures of 365 days
	 *                     in a year.
	 * @return the coldest day of the year. If there are more than one days with
	 *         equally low temperatures, it returns the first instance.
	 */
	public static int coldest(double[] temperatures) {
		int coldestDay = 0;
		double lowestTemperature = temperatures[0];
		for (int i = 0; i < temperatures.length; i++) {
			if (temperatures[i] < lowestTemperature) {
				lowestTemperature = temperatures[i];
				coldestDay = i;
			}
		}
		return coldestDay + 1;

	}

	/**
	 * Main method to quickly test if the coldest method is correct for a short
	 * array.
	 */
	public static void main(String[] args) {
		double[] temperatures = { 0, 10, -10, -10, 5 };
		System.out.println(coldest(temperatures));

	}

}