package com.mindgate.main;

import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeMain {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int empno = scanner.nextInt();
		
		System.out.println("Enter Employee Name");
		String ename = scanner.next();
		
		System.out.println("Enter Employee Salary");
		double sal = scanner.nextDouble();
		
		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
		
//		Employee employee = new Employee(1001, "XXXX", 666);
		Employee employee = new Employee(empno,ename,sal);
		boolean result = employeeServiceInterface.addNewEmployee(employee);
		
		if(result) {
			System.out.println("Insertion Successfull!!!!");
		}else {
			System.out.println("Insertion Failed");
		}
		
	}
}
