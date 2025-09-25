import java.util.ArrayList;
import java.util.Scanner;

// Custom exception for duplicate employee ID
class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}

// Custom exception for employee not found
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

// Employee class with id, name, designation
class Employee {
    private int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    // Display employee details
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation;
    }
}

public class EmployeeDirectory {
    private ArrayList<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    // Add new employee if ID is unique
    public void addEmployee(Employee emp) throws DuplicateEmployeeException {
        for (Employee e : employees) {
            if (e.getId() == emp.getId()) {
                throw new DuplicateEmployeeException("Employee with ID " + emp.getId() + " already exists.");
            }
        }
        employees.add(emp);
        System.out.println("Employee added: " + emp);
    }

    // Search employee by ID
    public Employee searchEmployee(int id) throws EmployeeNotFoundException {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    // Print all employees
    public void printAllEmployees() {
        System.out.println("\nEmployee Directory:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        try {
            // Adding employees
            directory.addEmployee(new Employee(101, "Anita", "Manager"));
            directory.addEmployee(new Employee(102, "Ram", "Developer"));
            directory.addEmployee(new Employee(103, "Raghu", "Designer"));
            
            // Attempt to add duplicate ID
            directory.addEmployee(new Employee(102, "Sanika", "Tester")); // Will throw exception
        } catch (DuplicateEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Search for employee
            Employee emp = directory.searchEmployee(101);
            System.out.println("Found employee: " + emp);

            // Search for non-existent employee
            directory.searchEmployee(999); // Will throw exception
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print all employees
        directory.printAllEmployees();
    }
}
