import java.util.ArrayList;

/**
 * The class Salaries stores a year's worth of monthly salaries of employees.
 * The field variable allsalaries is of type ArrayList which contains arrays of
 * type double. The class contains a constructor, which initialises allsalaries
 * as an empty ArrayList; a method add, which adds an array of salaries to
 * allsalaries; a method average, which computes the average salary for an
 * employee; a method averageSalaries which creates an array which stores
 * average salaries of all employees; a method not3TimesHigher, which checks if
 * any of the employees has a salary which is 3 times higher than the average of
 * the rest of the employees.
 * 
 * @author Ignas Stakaitis
 * @version 30/10/2019
 *
 */
public class Salaries {
	private ArrayList<double[]> allsalaries;

	/**
	 * The constructor Salaries initialises allsalaries to an empty ArrayList which
	 * contains arrays of doubles.
	 */
	public Salaries() {
		this.allsalaries = new ArrayList<double[]>();
	}

	/**
	 * The method add adds the argument salaries which is an array of doubles to the
	 * allsalaries ArrayList.
	 * 
	 * @param salaries an array of type double which represents the monthly salaries
	 *                 of an employee.
	 */
	public void add(double[] salaries) {
		this.allsalaries.add(salaries);
	}

	/**
	 * The method average returns an average of the argument employeeSalaries which
	 * is an array of doubles. If all of the elements of employeeSalaries are 0, and
	 * exception is thrown.<br>
	 * <br>
	 * a double sumMonthlySalaries and and int countMonths are initialised to 0. The
	 * method loops through employeeSalaries and adds each non 0 element to
	 * sumEmployeeSalaries and increments countMonths by 1.<br>
	 * <br>
	 * Once the loop is finished, the average, which is the sum of non zero salaries
	 * divided by the number of months which don't contain a salary of 0, is
	 * returned.
	 * 
	 * @param employeeSalaries an array of type double which represents the monthly
	 *                         salaries of an employee.
	 * @return the average salary of an employee, which is the sum of non zero
	 *         salaries divided by the number of months which don't contain a salary
	 *         of 0.
	 */
	public static double average(double[] employeeSalaries) {
		double sumMonthlySalaries = 0;
		int countMonths = 0;
		for (double element : employeeSalaries) {
			if (element != 0) {
				sumMonthlySalaries += element;
				countMonths++;
			}
		}
		if (countMonths == 0) {
			throw new IllegalArgumentException("Array must contain at least 1 non zero element.");
		}
		return sumMonthlySalaries / countMonths;
	}

	/**
	 * The method averageSalaries returns an ArrayList of doubles which contains the
	 * average salaries of all employees.<br>
	 * <br>
	 * An empty ArrayList avgSalaries is initialised. a double sumOfSalaries is set
	 * to 0. The method loops over the allsalaries field variable and within that
	 * loop, each element of each allsalaries array is added to sumOfSalaries. If
	 * sumOfSalaries is greater than 0, the average method is called and the average
	 * is added to the avgSalaries ArrayList. If all monthly salaries of an employee
	 * are 0, an exception is caught.
	 * 
	 * @return avgSalaries, which is an ArrayList of doubles containing the average
	 *         salaries of all employees.
	 */
	public ArrayList<Double> averageSalaries() {
		ArrayList<Double> avgSalaries = new ArrayList<Double>();
		double sumOfSalaries = 0;
		for (double[] employee : this.allsalaries) {
			for (double salary : employee) {
				sumOfSalaries += salary;
			}
			if (sumOfSalaries != 0) {
				try {
					avgSalaries.add(average(employee));
				} catch (IllegalArgumentException e) {
					System.out.println("method \"average\" called with array containing only 0");
				}

			}

		}
		return avgSalaries;
	}

	/**
	 * The method not3TimesHigher checks whether any employee has a salary which is
	 * 3 times higher than the average salary of all other employees.<br>
	 * <br>
	 * A double totalSalary and an int totalEmployees are set to 0. The method loops
	 * through the array of averageSalaries and each element is added to totalSalary
	 * and totalEmployees is incremented by 1.<br>
	 * <br>
	 * Another loop is used to loop through averageSalaries again and set the
	 * totalAverage equal to the totalSalary minus the salary that is being compared
	 * to the rest, divided by the number of employee minus the employee which is
	 * being compared. If the salary being compared is greater than 3 times the
	 * total average of other employees, false is returned. Otherwise, true is
	 * returned.
	 * 
	 * @return a boolean true if no employee average salaries are larger than 3
	 *         times the average of all other salaries and the boolean false
	 *         otherwise.
	 */
	public boolean not3TimesHigher() {
		double totalSalary = 0;
		int totalEmployees = 0;
		for (double salary : this.averageSalaries()) {
			totalSalary += salary;
			totalEmployees++;
		}

		for (double salary : this.averageSalaries()) {
			double totalAverage = (totalSalary - salary) / (totalEmployees - 1);
			if (salary > ((totalAverage) * 3)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Main method which tests the not3TimesHigher method.
	 */
	public static void main(String[] args) {
		Salaries s1 = new Salaries();
		double[] salaryJohn = { 100, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0 };
		double[] salaryJim = { 100, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0 };
		double[] salaryJames = { 100000, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0 };
		s1.add(salaryJames);
		s1.add(salaryJim);
		s1.add(salaryJohn);
		System.out.println(s1.not3TimesHigher());
	}
}