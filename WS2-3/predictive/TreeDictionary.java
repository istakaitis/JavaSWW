package predictive;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class contains an improved implementation of the Dictionary interface
 * using a Tree data structure, which allows parts of words to be returned for a
 * given partial signature.
 * 
 * @author Ignas Stakaitis
 *
 */
public class TreeDictionary implements Dictionary {

	/**
	 * This is an inner class which is used to construct a node for the tree used in
	 * the TreeDictionary class.
	 * 
	 * @author Ignas Stakaitis
	 *
	 */
	public class Node {
		/**
		 * An array of Node objects which represents the children of the tree.
		 */
		private Node[] children;

		/**
		 * A Set of type String which contains the words at a particular node.
		 */
		private Set<String> words = new TreeSet<String>();

		/**
		 * A constructor for the node class, which initialises the children array to
		 * size 8.
		 */
		public Node() {
			this.children = new Node[8];
		}
	}

	/**
	 * The root note for the tree dictionary.
	 */
	private Node treeDict = new Node();

	/**
	 * The constructor for the TreeDictionary class takes in a string which is the
	 * path to the dictionary adds words to a tree using the makeTree method.
	 * 
	 * @param path A string which is the path to the dictionary file.
	 */
	public TreeDictionary(String path) {
		File file = new File(path);

		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine().toLowerCase();
				if (PredictivePrototype.isValidWord(line)) {
					makeTree(treeDict, line, 0);
				}
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * This method creates a tree by adding words from the dictionary to the
	 * appropriate node (the root node must be kept empty).
	 * 
	 * @param tree  the tree to add words to.
	 * @param word  the word to add to the tree.
	 * @param level the level of the tree at which to add the word.
	 */
	public void makeTree(Node tree, String word, int level) {
		// if currently at the root node, do not add to the tree
		if (level == 0) {
			// signature is found
			String signature = PredictivePrototype.wordToSignature(word);
			// index of child is determined from the signature
			int newLevel = Character.getNumericValue(signature.charAt(level)) - 2;

			if (tree.children[newLevel] == null) {
				Node subTree = new Node();
				for (int i = 0; i < subTree.children.length; i++) {
					subTree.children[i] = new Node();
				}
				tree.children[newLevel] = subTree;
			}
			// recursive step
			makeTree(tree.children[newLevel], word, level + 1);
		} else { // if not at the root node, do add to the tree
			if (level == word.length()) {
				tree.words.add(word);
				return;
			}
			// signature is found
			String signature = PredictivePrototype.wordToSignature(word);
			// index of child is determined from the signature
			int newLevel = Character.getNumericValue(signature.charAt(level)) - 2;

			if (tree.children[newLevel] == null) {
				tree.words.add(word);
				Node subTree = new Node();
				for (int i = 0; i < subTree.children.length; i++) {
					subTree.children[i] = new Node();
				}
				tree.children[newLevel] = subTree;
			} else {
				tree.words.add(word);
			}
			// recursive step
			makeTree(tree.children[newLevel], word, level + 1);
		}
	}

	/**
	 * This method takes a signature and returns a set of words which correspond to
	 * the signature. This is achieved by searching the tree containing the
	 * dictionary using the searchTree method.
	 * 
	 * @param signature A string of numbers which correspond to words.
	 * @return a Set of type String which contains words which correspond to the
	 *         signature.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		// only numeric signatures are considered
		if (!signature.matches("[2-9]+")) {
			return new TreeSet<>();
		}
		return trim(searchTree(treeDict, signature, 0), signature.length());
	}

	/**
	 * This is a helper method for the signatureToWords method, which allows words
	 * to be found for a given signature. This method runs recursively in order to
	 * search different levels of the tree.
	 * 
	 * @param tree      The tree to be searched.
	 * @param signature The signature of the words to be searched.
	 * @param level     The level at which the tree is to be searched.
	 * @return
	 */
	public Set<String> searchTree(Node tree, String signature, int level) {
		if (level == signature.length()) {
			return tree.words;
		}
		// index of child is determined
		int index = Character.getNumericValue(signature.charAt(level)) - 2;

		if (tree.children[index] == null) {
			return new TreeSet<>();
		}
		return searchTree(tree.children[index], signature, level + 1);

	}

	/**
	 * This method trims the Strings in a set to the desired length, which allows
	 * partial signatures to return partial words.
	 * 
	 * @param set             The set of Strings to be trimmed.
	 * @param signatureLength The length to be trimmed to.
	 * @return A set of trimmed Strings.
	 */
	public static Set<String> trim(Set<String> set, int signatureLength) {
		Set<String> returnSet = new TreeSet<String>();
		for (String item : set) {
			if (item.length() > signatureLength) {
				returnSet.add(item.substring(0, signatureLength));
			} else {
				returnSet.add(item);
			}
		}
		return returnSet;
	}
}
