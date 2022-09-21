package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

@WebServlet("/AddNewEmployeeServlet")
public class AddNewEmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId;
		String name;
		double salary;
		response.setContentType("text/html");
		
		employeeId = Integer.parseInt(request.getParameter("employeeid"));
		name = request.getParameter("employeename");
        salary = Double.parseDouble(request.getParameter("salary"));
        
        Employee employee = new Employee(employeeId, name, salary);
        
        EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
        
        boolean result = employeeServiceInterface.addNewEmployee(employee);
        
        if(result) {
        	response.sendRedirect("index.jsp");
        }else {
        	PrintWriter out = response.getWriter();
        	out.println("Failed to add Employee!!!!");
        }
        
 //       PrintWriter out = response.getWriter();
 //       out.println("<h3>"+"Employee Id :"+ employeeId+ "<br>"+"Employee Name :"+ name+ "<br>"+"Employee Salary :"+ salary+"</h3>");
	}

}
