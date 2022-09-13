package com.floatinity.emp.dao;

import com.floatinity.emp.dao.beans.Department;
import com.floatinity.emp.request.DeptRequest;

public interface IDepartmentDAO extends IGenericDAO<Department> {
	
	public Department getDepartment(String name);
	

}
