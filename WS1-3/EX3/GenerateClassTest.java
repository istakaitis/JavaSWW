import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class GenerateClassTest contains JUnit tests for the class GenerateClass.
 * 
 * @author Ignas Stakaitis
 * @version 30/10/2019
 *
 */
class GenerateClassTest {

	private GenerateClass bankAccountClass;
	private GenerateClass companyClass;
	private GenerateClass emptyClass;

	@BeforeEach
	public void init() {
		String classname1 = "BankAccount";
		String[] variableNames1 = { "customer", "password", "balance", "statement" };
		String[] variableTypes1 = { "String", "String", "long", "ArrayList<String>" };
		bankAccountClass = new GenerateClass(classname1, variableNames1, variableTypes1);

		String classname2 = "Company";
		String[] variableNames2 = { "name", "url", "revenue" };
		String[] variableTypes2 = { "String", "String", "double" };
		companyClass = new GenerateClass(classname2, variableNames2, variableTypes2);

		String classname3 = "Empty";
		String[] variableNames3 = {};
		String[] variableTypes3 = {};
		emptyClass = new GenerateClass(classname3, variableNames3, variableTypes3);
	}

	@Test
	public void testMakeFields1() {
		String expectedFields = "  private String customer;\n" + "  private String password;\n"
				+ "  private long balance;\n" + "  private ArrayList<String> statement;\n\n";
		String actualFields = bankAccountClass.makeFields();
		assertEquals(expectedFields, actualFields, "expected fields do not match actual fields");
	}

	@Test
	public void testMakeFields2() {
		String expectedFields = "\n";
		String actualFields = emptyClass.makeFields();
		assertEquals(expectedFields, actualFields, "expected fields do not match actual fields");
	}

	@Test
	public void testMakeConstructor1() {
		String expectedConstructor = "  public Company(String name, String url, double revenue){\n"
				+ "    this.name = name;\n" + "    this.url = url;\n" + "    this.revenue = revenue;\n" + "  }\n";
		String actualConstructor = companyClass.makeConstructor();
		assertEquals(expectedConstructor, actualConstructor, "expected constructor does not match actual constructor");
	}

	@Test
	public void testMakeConstructor2() {
		String expectedConstructor = "  public Empty(){}\n";
		String actualConstructor = emptyClass.makeConstructor();
		assertEquals(expectedConstructor, actualConstructor, "expected constructor does not match actual constructor");
	}

	@Test
	public void testMakeGetters1() {
		String expectedGetters = "  public String getCustomer(){\n" + "    return customer;\n" + "  }\n"
				+ "  public String getPassword(){\n" + "    return password;\n" + "  }\n"
				+ "  public long getBalance(){\n" + "    return balance;\n" + "  }\n"
				+ "  public ArrayList<String> getStatement(){\n" + "    return statement;\n" + "  }\n";
		String actualGetters = bankAccountClass.makeGetters();
		assertEquals(expectedGetters, actualGetters, "expected getters do not match actual getters");
	}

	@Test
	public void testMakeGetters2() {
		String expectedGetters = "";
		String actualGetters = emptyClass.makeGetters();
		assertEquals(expectedGetters, actualGetters, "expected getters do not match actual getters");
	}

	@Test
	public void testMakeSetters1() {
		String expectedSetters = "  public void setName(String name){\n" + "    this.name = name;\n" + "  }\n"
				+ "  public void setUrl(String url){\n" + "    this.url = url;\n" + "  }\n"
				+ "  public void setRevenue(double revenue){\n" + "    this.revenue = revenue;\n" + "  }\n";
		String actualSetters = companyClass.makeSetters();
		assertEquals(expectedSetters, actualSetters, "expected setters do not match actual setters");
	}

	@Test
	public void testMakeSetters2() {
		String expectedSetters = "";
		String actualSetters = emptyClass.makeSetters();
		assertEquals(expectedSetters, actualSetters, "expected setters do not match actual setters");
	}
}
