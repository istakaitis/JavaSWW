// ORIGINAL CODE:
//public class Swap {
//	/**
//	 * swaps i and j
//	 * @param i 1st variable.
//	 * @param j 2nd variable.
//	 */
//	public static void swap(int i, int j) {
//		i = j;
//		j = i;
//	}
//	public static void main(String[] args) {
//		int i = 2;
//		int k = 6;
//		System.out.println("Original i: " + i + " k: " + k);
//		swap(i,k);
//		System.out.println("After swapping i: " + i + " k: " + k);
//	}
//}
/**
 * This class swaps the values of integers i and k within the main method. There
 * are two main problems with the original code. First, when swap(i,k) is
 * called, only copies of i and k are passed to the swap method. If the swap
 * method successfully swapped the two copies, the main method would still show
 * the original values after swapping as the swap that occured in the swap
 * method would not be passed back to the main method. This bring me to the
 * second problem. The swap method does not swap the values of int i and int j.
 * for example. if i = 2 and j = 6, when i = j is carried out, i becomes 6 and
 * when j = i is carried out j becomes equal to i which is 6.
 * 
 * @author Ignas Stakaitis
 * @version 05/10/2019
 *
 */
public class EX4 {

	public static void main(String[] args) {

		int i = 2;
		int k = 6;
		System.out.println("Original i: " + i + ", k = " + k);
		// variable temp created for temporary storage of the value of i
		int temp;
		temp = i;
		i = k;
		k = temp;

		System.out.println("After swapping i: " + i + ", k = " + k);

	}

}
