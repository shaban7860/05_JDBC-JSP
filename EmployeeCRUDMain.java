package com.mindgate.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
		int employeeId;
		String name;
		double salary;
		int choice;
		String choiceContinue;
		List<Employee> allEmployees;
		
		
		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
		do {
		
		System.out.println("1. Add New Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Select one Employee");
        System.out.println("5. Select All Employees");
        
        System.out.println("Enter your choice");
        
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        
        switch(choice) {
        case 1 : //add new employee
        	scanner = new Scanner(System.in);
        	
        	System.out.println("Enter Employee Id");
    		employeeId = scanner.nextInt();
    		
    		System.out.println("Enter Employee Name");
    		name = scanner.next();
    		
    		System.out.println("Enter Employee Salary");
    		salary = scanner.nextDouble();
    		
    		Employee employee = new Employee(employeeId,name,salary);
    		boolean result = employeeServiceInterface.addNewEmployee(employee);
    		
    		if(result) {
    			System.out.println("Insertion Successfull!!!!");
    		}else {
    			System.out.println("Insertion Failed");
    		}
        	break;
        
        case 2 : //update employee
        	
        	System.out.println("Enter Employee Id");
    		employeeId = scanner.nextInt();
    		
    		System.out.println("Enter Employee Name");
    		name = scanner.next();
    		
    		System.out.println("Enter Employee Salary");
    		salary = scanner.nextDouble();
    		
    		Employee employee2 = new Employee(employeeId,name,salary);
    		List<Employee> allEmployee = employeeServiceInterface.getAllEmployees();
    		
    		for(Employee e : allEmployee) {
    			if(e.getEmployeeId() == employee2.getEmployeeId()) {
    				System.out.println("Employee Updated");
    			}else {
    				System.out.println("");
    			}
    		}
        	break;
        	
        case 3 : //delete employee
        	System.out.println("Enter EmployeeId");
        	employeeId = scanner.nextInt();
        	boolean result1 = employeeServiceInterface.deleteEmployeeByEmployeeId(employeeId);
        	if(result1) {
    			System.out.println("Deleted Successfull!!!!");
    		}else {
    			System.out.println("Deletion Failed");
    		}
        	break;
        	
        case 4 : //select one employee
        	
        	break;
        	
        case 5 : //select all employee
            allEmployees = employeeServiceInterface.getAllEmployees();
            
            for(Employee e : allEmployees) {
            	System.out.println(e);
            }
        	break;
        	
        default : 
        	System.out.println("Invalid Choice");
        	break;
        }
        
        System.out.println("Do you want to continue ? Yes/No");
        choiceContinue = scanner.next();
		}while(choiceContinue.equals("yes"));
	}
}
