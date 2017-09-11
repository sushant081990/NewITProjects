package main.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DisplayEmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/viewEmployee/{id}", produces="application/json" ,method = RequestMethod.GET)
	public Employee viewAllItems(@PathVariable String id) {
		Employee allEmployees = employeeService.getAllEmployees(id);
		return allEmployees;

	}
	
	@RequestMapping(value="/saveEmployee/" ,method = RequestMethod.POST , produces="application/json",consumes ={"application/xml","application/json"})
	 
	public Employee saveAllItems(@RequestBody Employee employee) {
		Employee allEmployees = employeeService.saveEmployee(employee);
		return allEmployees;

	}
	
	@RequestMapping(value="/searchEmployee/" ,method = RequestMethod.POST , produces="application/json",consumes ={"application/xml","application/json"})
	 
	public List<Employee> searchEmloyee(@RequestBody Employee employee) {
		List<Employee> allEmployees = employeeService.searchEmployee(employee);
		return allEmployees;

	}
	
	
	@RequestMapping(value="/submitExpense/" ,method = RequestMethod.POST , produces="application/json",consumes ={"application/xml","application/json"})
	 
	public Expense submitExpense(@RequestBody Expense expense) {
		System.out.println("In Service Class");
		 expense = employeeService.submitExpense(expense);
		return expense;

	}
	
	
	@RequestMapping(value="/viewLatestTrascation/" ,method = RequestMethod.POST , produces="application/json",consumes ={"application/xml","application/json"})
	 
	public List<Expense> viewLatestTrascation(@RequestBody Expense expense) {
		System.out.println("In Service Class");
		List<Expense> latestExpenses = employeeService.viewLatestTrascation(expense);
		return latestExpenses;

	}
	
	
	@RequestMapping(value="/categorySearch/" ,method = RequestMethod.POST , produces="application/json",consumes ={"application/xml","application/json"})
	 
	public List<Expense> categorySearch(@RequestBody Expense expense) {
		System.out.println("In Service Class");
		List<Expense> categorizedExpenses = employeeService.categorySearch(expense);
		return categorizedExpenses;

	}
	
	
	
}
