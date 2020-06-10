/**
 * @author Ignas Stakaitis
 * 
 *         This class contains the solution for Worksheet1
 */
public class Worksheet1 {

	// Exercise 1
	/**
	 * This method raises a base m to a power n and returns the result. The
	 * computation is carried out in a simple recursive way.
	 * 
	 * @param m The base.
	 * @param n The exponent.
	 * @return The base raised to the power of the exponent.
	 */
	static int power(int m, int n) {
		if (n == 0) {
			return 1;
		} else {
			return m * power(m, n - 1);
		}
	}

	/**
	 * This method raises a base m to a power n and returns the result. The result
	 * is computed by diving the exponent by 2 and multiplying two resulting values
	 * of raising the base to the half-exponent, leading to a faster calculation.
	 * 
	 * @param m The base.
	 * @param n The exponent.
	 * @return The base raised to the power of the exponent.
	 */
	static int fastPower(int m, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			int halfPower = fastPower(m, n / 2);
			return halfPower * halfPower;
		} else {
			return m * fastPower(m, n - 1);
		}
	}

	// Exercise 2
	/**
	 * This method uses recursion to negate a list of integers a. As a result,
	 * positive integers become negative and negative integers become positive, and
	 * returns the new list.
	 * 
	 * @param a A list of integers.
	 * @return A list of integers with the signs negated.
	 */
	static List<Integer> negateAll(List<Integer> a) {
		if (a.isEmpty()) {
			return new List<Integer>();
		} else {
			return new List<Integer>(-1 * a.getHead(), negateAll(a.getTail()));
		}
	}

	// Exercise 3
	/**
	 * This method uses recursion to find whether a particular integer x is in a
	 * list of integers a. If the integer is indeed in the list, the index of the
	 * first instance of the integer is returned. Otherwise, an exception is thrown.
	 * 
	 * @param x An integer to be found in the list.
	 * @param a A list of integers.
	 * @return the index at which the first occurrence of x in a is found.
	 */
	static int find(int x, List<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException();
		} else if (a.getHead().equals(x)) {
			return 0;
		} else {
			return 1 + find(x, a.getTail());
		}
	}

	// Exercise 4
	/**
	 * This method checks whether all integers in a list a are even. If all of the
	 * integers in the list are even the method returns true, otherwise it returns
	 * false. If the list is empty, the condition is vacuously true.
	 * 
	 * @param a A list of integers.
	 * @return true if all integers in the list are even, false otherwise.
	 */
	static boolean allEven(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getHead() % 2 != 0) {
			return false;
		} else {
			return allEven(a.getTail());
		}
	}

	// Exercise 5
	/**
	 * This method takes a list a, finds the even numbers in the list and returns
	 * them in a new list.
	 * 
	 * @param a A list of integers.
	 * @return A list of integers containing only even numbers.
	 */
	static List<Integer> evenNumbers(List<Integer> a) {
		if (a.isEmpty()) {
			return a;
		} else if (a.getHead() % 2 == 0) {
			return new List<Integer>(a.getHead(), evenNumbers(a.getTail()));
		} else {
			return evenNumbers(a.getTail());
		}
	}

	// Exercise 6
	/**
	 * This method checks whether a list a is sorted in a descending order, and if
	 * it is, the method returns true. Otherwise, the method returns false. An empty
	 * list is considered sorted (vacuous truth).
	 * 
	 * @param a A list of integers.
	 * @return true if the list is sorted in descending order, false otherwise.
	 */
	static boolean sorted(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		}
		if (a.getTail().isEmpty()) {
			return true;
		} else if (a.getHead() >= a.getTail().getHead()) {
			return sorted(a.getTail());
		} else {
			return false;
		}
	}

	// Exercise 7
	/**
	 * This method takes two lists of integers a and b, which are sorted in
	 * descending order, and merges the two lists to produce a larger list, while
	 * maintaining duplicate values.
	 * 
	 * @param a A list of integers, sorted in descending order.
	 * @param b A list of integers, sorted in descending order.
	 * @return A merged list which contains the values of a and b.
	 */
	static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) {
			return b;
		}
		if (b.isEmpty()) {
			return a;
		}
		if (a.getHead() >= b.getHead()) {
			return new List<Integer>(a.getHead(), merge(a.getTail(), b));
		} else {
			return new List<Integer>(b.getHead(), merge(a, b.getTail()));
		}
	}

	// Exercise 8
	/**
	 * This method takes a list of integers a, which is sorted in descending order
	 * and returns a new list which has no duplicate integers.
	 * 
	 * @param a A list of integers, sorted in descending order.
	 * @return A list which does not contain duplicate integers.
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return a;
		} else if (a.getHead().equals(a.getTail().getHead())) {
			return removeDuplicates(a.getTail());
		} else {
			return new List<Integer>(a.getHead(), removeDuplicates(a.getTail()));
		}
	}

}