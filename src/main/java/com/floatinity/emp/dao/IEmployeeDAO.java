package com.floatinity.emp.dao;

import java.util.List;

import com.floatinity.emp.dao.beans.Employee;
import com.floatinity.emp.dao.beans.Leave;
import com.floatinity.emp.request.EmployeeRequest;

public interface IEmployeeDAO extends IGenericDAO<Employee> {

	public Employee getEmployeeByEmail(String email);

	public Employee getEmployeebyname(String name);

	public Employee getEmployee(Integer id);

	public List<Employee> getEmployeebyDate();
	
	
}
