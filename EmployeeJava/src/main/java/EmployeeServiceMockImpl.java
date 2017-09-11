package main.java;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Component
public class EmployeeServiceMockImpl implements EmployeeService {

	DBCollection employeeTable;
	DBCollection expenseTable;

	private List<Employee> testEmployees = new ArrayList<Employee>();

	public EmployeeServiceMockImpl() {
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("169.55.43.248", 64895);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		DB db = mongo.getDB("Walgreens");

		employeeTable = db.getCollection("Employees");
		expenseTable = db.getCollection("Expense");
	}

	@Override
	public Employee getAllEmployees(String Id) {

		Employee searchedEmployee = new Employee();

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("EmployeeId", Id);

		DBCursor cursor = employeeTable.find(searchQuery);

		while (cursor.hasNext()) {

			DBObject user = cursor.next();

			searchedEmployee.setEmpId((String) user.get("EmployeeId"));
			searchedEmployee.setName((String) user.get("Name"));
			searchedEmployee.setDesignation((String) user.get("Designation"));
			// searchedEmployee.setSalary((Double)user.get("Salary"));

		}
		return searchedEmployee;

	}

	@Override
	public Employee saveEmployee(Employee employee) {

		BasicDBObject document = new BasicDBObject();
		document.put("EmployeeId", employee.getEmpId());
		document.put("Name", employee.getName());
		document.put("Designation", employee.getDesignation());
		document.put("Salary", employee.getSalary());
		document.put("createdDate", new Date());
		employeeTable.insert(document);
		return employee;

	}

	@Override
	public List<Employee> searchEmployee(Employee employee) {
		List<Employee> searchedEmployeeList = new ArrayList<Employee>();

		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		if (!(null == employee.getEmpId() || "".equalsIgnoreCase(employee.getEmpId()))) {
			obj.add(new BasicDBObject("EmployeeId", employee.getEmpId()));
		}
		if (!(null == employee.getName() || "".equalsIgnoreCase(employee.getName()))) {
			obj.add(new BasicDBObject("Name", employee.getName()));
		}
		if (!(null == employee.getDesignation() || "".equalsIgnoreCase(employee.getDesignation()))) {
			obj.add(new BasicDBObject("Designation", employee.getDesignation()));
		}

		if (!(null == employee.getSalary())) {
			obj.add(new BasicDBObject("Salary", employee.getSalary()));
		}
		andQuery.put("$and", obj);

		System.out.println(andQuery.toString());

		DBCursor cursor = employeeTable.find(andQuery);
		// System.out.println("No of Records found from DB" +
		// cursor.getSizes());
		while (cursor.hasNext()) {

			Employee searchedEmployee = new Employee();
			DBObject user = cursor.next();
			System.out.println("After Database Call");
			System.out.println("Employee ID" + (String) user.get("EmployeeId"));
			System.out.println("Employee Name" + (String) user.get("Name"));
			System.out.println("Employee Designation" + (String) user.get("Designation"));

			searchedEmployee.setEmpId((String) user.get("EmployeeId"));
			searchedEmployee.setName((String) user.get("Name"));
			searchedEmployee.setDesignation((String) user.get("Designation"));
			searchedEmployee.setSalary((Double) user.get("Salary"));

			searchedEmployeeList.add(searchedEmployee);
		}

		System.out.println("No of Records found in DB" + searchedEmployeeList.size());
		// TODO Auto-generated method stub
		return searchedEmployeeList;
	}

	@Override
	public Expense submitExpense(Expense expense) {

		System.out.println("In BO CLass");

		BasicDBObject document = new BasicDBObject();
		document.put("Amount", expense.getExpenesAmount());
		document.put("Descriription", expense.getDescription());
		document.put("Category", expense.getExpenseCategory());
		document.put("createdDate", new Date());
		System.out.println("Before Inserting");
		expenseTable.insert(document);
		System.out.println("After inserting");

		return expense;
	}

	@Override
	public List<Expense> viewLatestTrascation(Expense expense) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> categorySearch(Expense expense) {

		List<Expense> categorizedExpenseList = new ArrayList<Expense>();

		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		if (!(null == expense.getExpenseCategory() || "".equalsIgnoreCase(expense.getExpenseCategory()))) {
			obj.add(new BasicDBObject("Category", expense.getExpenseCategory()));
		}

		andQuery.put("$and", obj);

		System.out.println(andQuery.toString());

		DBCursor cursor = expenseTable.find(andQuery);

		while (cursor.hasNext()) {

			Expense categorizedExpense = new Expense();
			DBObject user = cursor.next();

			categorizedExpense.setDescription((String) user.get("Descriription"));
			categorizedExpense.setExpenseCategory((String) user.get("Category"));

			categorizedExpense.setExpenesAmount((Double) user.get("Amount"));

			categorizedExpenseList.add(categorizedExpense);
		}

		System.out.println("No of Records found in DB" + categorizedExpenseList.size());
		// TODO Auto-generated method stub
		return categorizedExpenseList;
	}

}
