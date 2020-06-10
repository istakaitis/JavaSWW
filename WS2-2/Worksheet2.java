/**
 * @author Ignas Stakaitis
 * 
 *         This class contains the solution for Worksheet2.
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1
	/**
	 * This method returns all of the elements of tree t with their signs negated in
	 * a new tree (positive integers become negative, negative integers become
	 * positive).
	 * 
	 * @param t A tree of integers.
	 * @return A tree with all of the integers negated.
	 */
	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()) {
			return new Tree<Integer>();
		} else {
			return new Tree<Integer>(-1 * t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	// Exercise 2
	/**
	 * This method checks whether all integers in the tree are even and returns true
	 * if they are. If there is at least one integer that is odd, returns false. If
	 * the list is empty, the allEven method is vacuously true.
	 * 
	 * @param a A tree of integers.
	 * @return true if all of the integers are even, false otherwise.
	 */
	static boolean allEven(Tree<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() % 2 != 0) {
			return false;
		} else {
			return allEven(a.getRight()) && allEven(a.getLeft());
		}
	}

	// Exercise 3
	/**
	 * This method checks whether the node value x is present in the tree and if it
	 * is, returns the depth. Otherwise, returns -1.
	 * 
	 * @param a A tree of integers.
	 * @param x A node value.
	 * @return The depth of the node. If the node is not in the tree, returns -1.
	 */
	static int depth(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return -1;
		} else if (a.getValue() == x) {
			return 0;
		} else {
			if (Math.max(depth(a.getLeft(), x), depth(a.getRight(), x)) == -1) {
				return -1;
			} else {
				return 1 + Math.max(depth(a.getLeft(), x), depth(a.getRight(), x));
			}
		}
	}

	// Exercise 4
	/**
	 * This method returns a list which contains the values of a by traversing the
	 * nodes in preorder.
	 * 
	 * @param <E> Indication of generic type.
	 * @param a   A tree of type E.
	 * @return A list which contains the values of tree a in preorder.
	 */
	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<E>();
		} else {
			return append(new List<E>(a.getValue(), preorder(a.getLeft())), preorder(a.getRight()));
		}
	}

	/**
	 * This method creates a list which is the result of list b appended to the end
	 * of list a. This method is adapted from the ListOps class in the lecture
	 * notes.
	 * 
	 * @param <E> Indication of generic type.
	 * @param a   A list of type E.
	 * @param b   A list of type E.
	 * @return A list which is list b appended to the end of list a.
	 */
	public static <E> List<E> append(List<E> a, List<E> b) {
		if (a.isEmpty()) {
			return b;
		} else {
			return new List<E>(a.getHead(), append(a.getTail(), b));
		}
	}

	// Exercise 5
	/**
	 * This method checks if the input tree a is a binary search tree and returns
	 * true if it is and false otherwise. Vacuous truth is applied for an empty
	 * tree.
	 * 
	 * @param a A tree of integers.
	 * @return true if tree a is a binary search tree, false otherwise.
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty() || ((a.getLeft().isEmpty() && (a.getRight().isEmpty())))) {
			return true;
		} else if (a.getLeft().getValue() >= a.getValue() || a.getRight().getValue() <= a.getValue()) {
			return false;
		} else {
			return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
		}
	}

	// Exercise 6
	/**
	 * This method prints the integers of a binary search tree a in a descending
	 * order.
	 * 
	 * @param a A binary search tree of integers.
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty()) {
			return;
		} else {
			printDescending(a.getRight());
			System.out.print(a.getValue() + " ");
			printDescending(a.getLeft());
		}
	}

	// Exercise 7
	/**
	 * This method finds and returns the maximum integer value in a binary search
	 * tree a. If the tree is empty, an error is thrown, as no maximum value can be
	 * found.
	 * 
	 * @param a A binary search tree of integers.
	 * @return the maximum integer in the binary search tree.
	 */
	static int max(Tree<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalStateException("Empty tree cannot return a maximum integer");
		} else if (a.getRight().isEmpty()) {
			return a.getValue();
		} else {
			return max(a.getRight());
		}
	}

	// Exercise 8
	/**
	 * This method deletes an integer x from a binary search tree a and returns the
	 * resulting binary search tree. It covers the cases of x being a leaf, x being
	 * a node with one child and x being a node with two children.
	 * 
	 * @param a A binary search tree of integers.
	 * @param x An integer to be deleted from the tree.
	 * @return A binary search tree of integers where x has been deleted from a.
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		// if the tree is empty, return empty tree
		if (a.isEmpty()) {
			return new Tree<Integer>();
			// if x is equal to the value of the node and there are no children, return an
			// empty tree
		} else if (x == a.getValue() && (a.getLeft().isEmpty() && a.getRight().isEmpty())) {
			return new Tree<Integer>();
			// if x is equal to the value of the node and there is one child
		} else if (x == a.getValue() && (a.getLeft().isEmpty() || a.getRight().isEmpty())) {
			if (a.getLeft() == null) {
				return new Tree<Integer>(a.getRight().getValue());
			} else {
				return new Tree<Integer>(a.getLeft().getValue());
			}
			// if x is equal to the value of the node and there are two children
		} else if (x == a.getValue() && (!a.getLeft().isEmpty() && !a.getRight().isEmpty())) {
			// maximum of the left subtree is found
			int max = max(a.getLeft());
			return new Tree<Integer>(max, delete(a.getLeft(), max), delete(a.getRight(), max));
		} else {
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), delete(a.getRight(), x));
		}
	}

	// Exercise 9
	/**
	 * This method checks whether a given binary search tree is height-balanced. It
	 * returns true tree a is height balanced and false otherwise. If the tree is
	 * empty, vacuous truth is applied.
	 * 
	 * @param <E> Indication of generic type.
	 * @param a   A tree of type E.
	 * @return true if tree is height-balanced, false otherwise.
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty()) {
			return true;
		}
		if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) > 1) {
			return false;
		} else {
			return true;
		}
	}

	// Exercise 10
	/**
	 * This method inserts integer x into a height-balanced binary search tree a and
	 * returns the resulting height-balanced tree. It uses the rotate method,
	 * described below.
	 * 
	 * @param a A height-balanced binary search tree.
	 * @param x An integer to be inserted.
	 * @return A height-balanced binary search tree containing x.
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>(x);
		} else if (a.getValue() > x) {
			return rotate(new Tree<Integer>(a.getValue(), insertHB(a.getLeft(), x), a.getRight()));
		} else {
			return rotate(new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x)));
		}
	}

	/**
	 * This method deletes an integer x from a height-balanced binary search tree a
	 * and returns the resulting height-balanced tree. it uses the delete method
	 * (exercise 8) and the rotate method described below.
	 * 
	 * @param a A height-balanced binary search tree.
	 * @param x An integer to be deleted.
	 * @return A height-balanced binary search tree which does not contain x.
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		// if the tree is empty, return empty tree
		if (a.isEmpty()) {
			return new Tree<Integer>();
			// if x is equal to the value of the node and there are no children, return an
			// empty tree
		} else if (x == a.getValue() && (a.getLeft().isEmpty() && a.getRight().isEmpty())) {
			return new Tree<Integer>();
			// if x is equal to the value of the node and there is one child
		} else if (x == a.getValue() && (a.getLeft().isEmpty() || a.getRight().isEmpty())) {
			if (a.getLeft() == null) {
				return rotate(new Tree<Integer>(a.getRight().getValue()));
			} else {
				return rotate(new Tree<Integer>(a.getLeft().getValue()));
			}
			// if x is equal to the value of the node and there are two children
		} else if (x == a.getValue() && (!a.getLeft().isEmpty() && !a.getRight().isEmpty())) {
			// maximum of the left subtree is found
			int max = max(a.getLeft());
			return rotate(new Tree<Integer>(max, delete(a.getLeft(), max), delete(a.getRight(), max)));
		} else {
			return rotate(new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), delete(a.getRight(), x)));
		}
	}

	/**
	 * This is a helper method for insertHB and deleteHB. It takes in a binary
	 * search tree, checks whether it is height-balanced and if not, performs a
	 * necessary rotation and returns a height-balanced binary search tree.
	 * 
	 * @param a A binary search tree.
	 * @return A height-balanced binary search tree.
	 */
	static Tree<Integer> rotate(Tree<Integer> a) {
		if (isHeightBalanced(a)) {
			return a;
		} else {
			if (getBalanceFactor(a) > 1 && getBalanceFactor(a.getLeft()) >= 0) { // LL case
				return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(),
						new Tree<Integer>(a.getValue(), a.getLeft().getRight(), a.getRight()));

			} else if (getBalanceFactor(a) < -1 && getBalanceFactor(a.getRight()) <= 0) { // RR case
				return new Tree<Integer>(a.getRight().getValue(),
						new Tree<Integer>(a.getValue(), a.getLeft(), a.getRight().getLeft()), a.getRight().getRight());

			} else if (getBalanceFactor(a) > 1) { // LR case
				return new Tree<Integer>(a.getLeft().getRight().getValue(),
						new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(),
								a.getLeft().getRight().getLeft()),
						new Tree<Integer>(a.getValue(), a.getLeft().getRight().getRight(), a.getRight()));

			} else { // RL case
				return new Tree<Integer>(a.getRight().getLeft().getValue(),
						new Tree<Integer>(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()),
						new Tree<Integer>(a.getRight().getValue(), a.getRight().getLeft().getRight(),
								a.getRight().getRight()));
			}
		}
	}

	/**
	 * This helper method calculates the balance factor of tree a.
	 * 
	 * @param a A binary tree of integers.
	 * @return the balance factor.
	 */
	static int getBalanceFactor(Tree<Integer> a) {
		return a.getLeft().getHeight() - a.getRight().getHeight();
	}
}