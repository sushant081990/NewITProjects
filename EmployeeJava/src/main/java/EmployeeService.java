package main.java;

import java.util.List;

public interface EmployeeService {
	public Employee getAllEmployees(String Id);
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee>  searchEmployee(Employee employee);
	
	public Expense  submitExpense(Expense expense);
	
	public List<Expense> viewLatestTrascation(Expense expense);
	
	public List<Expense> categorySearch(Expense expense);

}


