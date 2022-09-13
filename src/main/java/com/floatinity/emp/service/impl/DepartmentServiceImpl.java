package com.floatinity.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floatinity.core.object.FLOUtil;
import com.floatinity.emp.dao.IDepartmentDAO;
import com.floatinity.emp.dao.beans.Department;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.DeptRequest;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.response.DeptResponse;
import com.floatinity.emp.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	private static final Logger LOG = LogManager.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private IDepartmentDAO deptDAO;

	@Override
	public void createDepartment(DeptRequest request) throws EMPException {

		LOG.info("Inside create Department");
		String name = request.getDeptName();
		// 1) check weather Department is present

		Department dept = deptDAO.getDepartment(name);
		if (null != dept) {
			LOG.error("Department already exsist");
			throw new EMPException(EMPError.EMP_ERR_DEPARTMENT_ALREADY_EXIST);
		}
		// 2) create the Department
		Department d = new Department();
		BeanUtils.copyProperties(request, d);
		System.out.println(d);
		deptDAO.save(d);
		LOG.debug("Department created:", d);
	}

	@Override
	public void updateDepartment(DeptRequest request) throws EMPException {
		// 1. check if the department is present
		LOG.info("Inside Udate Department");
		int id = request.getId();
		Department d = deptDAO.getById(Department.class, id);

		if (null == d) {
			LOG.error(" Invalid Department ID");
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}
		// 2.update the department
		Department dept = new Department();

		BeanUtils.copyProperties(request, dept);
		deptDAO.update(dept);
		LOG.info("Department updated");
	}

	@Override
	public void deleteDepartment(DeptRequest request) throws EMPException {
		// TODO 1)check if the department is Present or not
		LOG.info("Inside delete Department");
		int id = request.getId();
		Department dept = deptDAO.getById(Department.class, id);

		if (null == dept) {
			LOG.error("Department with this id does not exsist");
			throw new EMPException("INVALID DEPARTMENT ID");
		}

		// TODO 2)delete the department
		Department d = new Department();
		BeanUtils.copyProperties(request, d);
		deptDAO.deleteByID(Department.class, id);
		LOG.debug("Department delted", d);
	}

	@Override
	public Department getDepartment(IdRequest request) {
		// TODO Auto-generated method stub
//		int id = request.getId();
		return deptDAO.getById(Department.class, request.getId());

	}

	@Override
	public List<DeptResponse> getAllDepartment() throws EMPException {
		LOG.info("Inside get all users");
		List<DeptResponse> deptResponseList = null;
		List<Department> dept = deptDAO.getAll(Department.class);
		if (!FLOUtil.isNullOrEmpty(dept)) {
			deptResponseList = new ArrayList<>();

		} else {
			LOG.debug("Department not present");
		}
		return deptResponseList;
	}

}
