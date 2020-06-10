/**
 * This class takes different imperial units and returns their sum converted to
 * kilogrammes.
 * 
 * @author Ignas Stakaitis
 * @version 04/10/2019
 */

public class EX2 {

	/**
	 * @param ton,           mass in tons
	 * @param hundredweight, mass in hundredweight
	 * @param quarter,       mass in quarters
	 * @param stone,         mass in stone
	 * @param pound,         mass in pounds
	 * @param ounce,         mass in ounces
	 * @param drachm,        mass in drachm
	 * @param grain,         mass in grain
	 * @return the total mass in kilogrammes
	 */
	public static double imperialToKg(double ton, double hundredweight, double quarter, double stone, double pound,
			double ounce, double drachm, double grain) {
		// converting every unit to pounds and adding
		double massInPounds = ton * 2240 + hundredweight * 112 + quarter * 28 + stone * 14 + pound + ounce / 16
				+ drachm / 256 + grain / 7000;
		// converting pounds to kilogrammes
		double massInKilogrammes = massInPounds * 0.45359237;
		return massInKilogrammes;
	}

	public static void main(String[] args) {
		// testing conversion of 11 stone and 6 pounds to kilogrammes
		System.out.println(imperialToKg(0, 0, 0, 11, 6, 0, 0, 0));
	}

}
