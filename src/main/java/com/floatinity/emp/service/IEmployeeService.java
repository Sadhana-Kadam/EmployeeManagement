package com.floatinity.emp.service;

import java.util.List;

import com.floatinity.emp.dao.beans.Employee;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.EmployeeRequest;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.request.NameRequest;

public interface IEmployeeService {

	public void deleteEmployee(IdRequest request) throws EMPException;

	public void updateEmployee(EmployeeRequest request) throws EMPException;

	public void createEmployee(EmployeeRequest request) throws EMPException;

	public Employee getEmployee(IdRequest request)throws EMPException;

	Employee getEmployeebyname(EmployeeRequest request) throws EMPException;

	// void updateEmployee(IdRequest request) throws EMPException;

	public Employee SearchEmployee(EmployeeRequest request) throws EMPException;

	public List<Employee> getEmployeeRecord();

	
}
