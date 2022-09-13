package com.floatinity.emp.service;

import java.util.List;

import com.floatinity.emp.dao.beans.Department;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.DeptRequest;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.response.DeptResponse;

public interface IDepartmentService {

	public void createDepartment(DeptRequest request) throws EMPException;

	public void updateDepartment(DeptRequest request) throws EMPException;

	public void deleteDepartment(DeptRequest request) throws EMPException;

	public List<DeptResponse> getAllDepartment() throws EMPException;

	public Department getDepartment(IdRequest request);

}
