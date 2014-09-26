package edu.indiana.cs.c212;

import java.util.ArrayList;
import java.util.List;

public class Lab5 
{
	public List<Employee> empList;

    /**
     * This constructor should create an instance of ArrayList to store list of employees. 
     */
	public Lab5()
	{
		this.empList = new ArrayList<Employee>();
	}

	/**
	 * @param Employee emp
	 * 
	 * addEmployee is a method that takes an Employee object and adds it to
	 * ArrayList<Employee> that contains information of all employees
	 * 
	 * Operations to know for ArrayLists:
	 *   Let list be an ArrayList<Employee> and emp be an Employee:
	 *   	list.add(emp) will add emp to the end of your list
	 *      
	 * For more information on ArrayLists see:
	 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
	 */
	public void addEmployee(Employee emp)
	{
		this.empList.add(emp);
	}

	/**
	 * @param String
	 * @return Employee
	 * 
	 * findEmployee is a method that takes an employee name as a parameter and
	 * searches ArrayList<Employee> to find the employee with that name
	 *
	 * For more information on Iterators see:
	 * http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
	 */
	public Employee findEmployee(String empName)
	{
		for (int i = 0; i < empList.size(); i++) {
			Employee current = empList.get(i);
			if (current.getEmpName().equals(empName)) {
				return current;
			}
		}
		return null;
	}

	/**
	 * @param String empName
	 * @return Employee
	 * 
	 * removeEmployee is a method that takes an employee name as a parameter and
	 * searches ArrayList<Employee>, removing the employee with that name if they are
	 * in the ArrayList
	 */
	public void removeEmployee(String empName)
	{
		for (int i = 0; i < empList.size(); i++) {
			Employee current = empList.get(i);
			if (current.getEmpName().equals(empName)) {
			empList.remove(i);
			}
		}
	}
	/**
	 * @return Employee
	 * 
	 * getMaxSalaryEmp is a method that searches ArrayList<Employee> 
	 * and returns an employee with the maximum salary
	 */
	public Employee getMaxSalaryEmp()
	{
		Employee bestpaid = empList.get(0);
		for (int i = 0; i < empList.size(); i++) {
			Employee current = empList.get(i);
			if (current.getSalary() > bestpaid.getSalary()) {
				bestpaid = current;
			}
			
		}
		return bestpaid;
	}

	/**
	 * @param double percentage
	 * @return Employee
	 * 
	 * raiseSalary is a method that raises all employees' salaries
	 * by given percentage
	 */
	public void raiseSalary(double percentage)
	{
		for (Employee current: empList) {
			current.setSalary(current.getSalary() * (1.0 + (percentage / 100.0)));
			}
		}

	/**
	 * @param Employee emp
	 * 
	 * displayEmployee is a method that displays employee name, salary and join year to the console
	 */
	public void displayEmployee(Employee emp)
	{
		System.out.println("Employee Name: " + emp.getEmpName());
		System.out.println("Employee Salary: " + emp.getSalary());
		System.out.println("Employee Join Year: " + emp.getJoinYear());
	}

	public static void main(String[] args)
	{
		//FIXME

		// Add employees to the list
		Lab5 lab5 = new Lab5();

		// Find employee
		lab5.addEmployee(new Employee("Bryan", 3, 2002));
		lab5.addEmployee(new Employee("Jim", 3, 2002));
		lab5.addEmployee(new Employee("Scotty", 3, 2002));
		lab5.addEmployee(new Employee("Vader", 3, 2002));
		lab5.addEmployee(new Employee("Moss", 3, 2002));
		
		// display employee details
		
		
		// display maximum salary employee details

		// increase salary of all employees by 10 percent

		// delete employee from list

		// display employee details for all employees
	}
} 
