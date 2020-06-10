import java.io.*;

/**
 * The class GenerateClass writes to a file a class with specified field
 * variables, a constructor, setters and getters. The three fields classname,
 * variableNames and variableTypes are of types String, array of strings and
 * array of strings respectively.
 * 
 * @author Ignas Stakaitis
 * @version 30/10/2019
 */
public class GenerateClass {
	private String classname;
	private String[] variableNames;
	private String[] variableTypes;

	/**
	 * The constructor GenerateClass initialises the class name, the variable names
	 * and the corresponding variable types.
	 * 
	 * @param classname     the name of the class to be created.
	 * @param variableNames the variable names used in the class.
	 * @param variableTypes the variable types associated with each variable.
	 */
	public GenerateClass(String classname, String[] variableNames, String[] variableTypes) {
		this.classname = classname;
		this.variableNames = variableNames;
		this.variableTypes = variableTypes;
	}

	/**
	 * The makeFields method generates the fields from the variableNames and
	 * variableTypes arrays.<br>
	 * <br>
	 * The method loops through the variableNames array (both are of equal length)
	 * and returnString is appended to.
	 * 
	 * @return returnString which is a string representing all of the fields.
	 */
	public String makeFields() {
		String returnString = "";
		for (int index = 0; index < this.variableNames.length; index++) {
			returnString += "  private " + this.variableTypes[index] + " " + this.variableNames[index] + ";\n";
		}
		returnString += "\n";
		return returnString;
	}

	/**
	 * The makeConstructor method generates the constructor from the variableNames
	 * and variableTypes arrays. .<br>
	 * <br>
	 * The method loops through the variableNames array (both are of equal length)
	 * and returnString is appended to. Conditional statements are used to
	 * anticipate the case of a constructor which does not take arguments.
	 * 
	 * @return returnString which is a string representing the constructor.
	 */
	public String makeConstructor() {
		String returnString = "  public " + this.classname + "(";

		for (int index = 0; index < this.variableNames.length; index++) {
			returnString += this.variableTypes[index] + " " + this.variableNames[index];
			if (index != (this.variableNames.length - 1)) {
				returnString += ", ";
			}
		}
		if (this.variableNames.length > 0) {
			returnString += "){\n";
		} else
			returnString += "){";
		for (int index = 0; index < this.variableNames.length; index++) {
			returnString += "    this." + this.variableNames[index] + " = " + this.variableNames[index] + ";\n";
		}
		if (this.variableNames.length > 0) {
			returnString += "  }\n";
		} else {
			returnString += "}\n";
		}
		return returnString;
	}

	/**
	 * The makeGetters method generates the getters from the variableNames and
	 * variableTypes arrays.<br>
	 * <br>
	 * The method loops through the variableNames array (both are of equal length)
	 * and returnString is appended to. The first letter of the variable name is
	 * capitalised. This requires the substring and toUpperCase methods.
	 * 
	 * @return returnString which is a string representing the getters.
	 */
	public String makeGetters() {
		String returnString = "";
		for (int index = 0; index < this.variableNames.length; index++) {
			returnString += "  public ";
			returnString += this.variableTypes[index] + " get";
			String firstLetter = this.variableNames[index].substring(0, 1).toUpperCase();
			returnString += firstLetter + this.variableNames[index].substring(1, this.variableNames[index].length());
			returnString += "(){\n    return " + this.variableNames[index] + ";\n  }\n";
		}

		return returnString;
	}

	/**
	 * The makeSetters method generates the setters from the variableNames and
	 * variableTypes arrays.<br>
	 * <br>
	 * The method loops through the variableNames array (both are of equal length)
	 * and returnString is appended to. The first letter of the variable name is
	 * capitalised. This requires the substring and toUpperCase methods.
	 * 
	 * @return returnString which is a string representing the setters.
	 */
	public String makeSetters() {
		String returnString = "";
		for (int index = 0; index < this.variableNames.length; index++) {
			returnString += "  public void set";
			String firstLetter = this.variableNames[index].substring(0, 1).toUpperCase();
			returnString += firstLetter + this.variableNames[index].substring(1, this.variableNames[index].length());
			returnString += "(" + this.variableTypes[index] + " " + this.variableNames[index] + ")";
			returnString += "{\n    this." + this.variableNames[index] + " = " + this.variableNames[index] + ";\n  }\n";
		}
		return returnString;
	}

	/**
	 * The writeFile method writes to a file named by the field variable classname
	 * and is given a .java extension. The previously defined methods are used in
	 * the order makeFields, makeConstructor, makeGetters and makeSetters. try and
	 * catch are used to anticipate cases where the classname might be empty.
	 */
	public void writeFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(this.classname + ".java"));
			out.write("public class " + this.classname + " {\n" + this.makeFields() + this.makeConstructor() + "\n"
					+ this.makeGetters() + "\n" + this.makeSetters() + "\n" + "}");
			out.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * Main method to test writing to a file and whether Person.java compiles.
	 * 
	 */
	public static void main(String[] args) {
		String[] array1 = { "name", "dob" };
		String[] array2 = { "String", "Date" };
		GenerateClass test = new GenerateClass("Person", array1, array2);
		test.writeFile();

	}

}
