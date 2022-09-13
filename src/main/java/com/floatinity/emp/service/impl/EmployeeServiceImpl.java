package com.floatinity.emp.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floatinity.emp.dao.IEmployeeDAO;
import com.floatinity.emp.dao.beans.Employee;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.EmployeeRequest;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public void createEmployee(EmployeeRequest request) throws EMPException {
		// request validate
		request.validate();
		LOG.info("inside create employee");

		String email = request.getEmail();

		// 1. check employee already exist or not
		Employee employee = empDAO.getEmployeeByEmail(email);
		if (null != employee) {
			LOG.error("Employee already exist with this email :", email);
			throw new EMPException(EMPError.EMP_ERR_EMPLOYEE_ALREADY_EXIST_WTIH_THIS_EMAIL);
		}
		// : 2. save employee details
		Employee emp = new Employee();
		emp.setStatus(Boolean.TRUE);
		// ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		emp.setDateofJoining(request.getDateofJoinning());

		BeanUtils.copyProperties(request, emp);
		System.out.println(emp);
		empDAO.save(emp);

		LOG.debug("Employee data stored:");

	}

	@Override
	public void deleteEmployee(IdRequest request) throws EMPException {
		// 1 . check weather the request is valid
		request.validate();
		LOG.info("Inside Delete employee");

		int id = request.getId();
		// 2. to check the id/employee is present in database or not
		Employee emp = empDAO.getById(Employee.class, id);
		if (null == emp) {
			LOG.error("Employee with this id does not exsit", id);
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}

		emp.setStatus(false);

		// 3. if present delete the data
		empDAO.save(emp);
		LOG.info("employee marked deleted sucessfully");
		// empDAO.deleteByID(Employee.class, id);
	}

	@Override
	public void updateEmployee(EmployeeRequest request) throws EMPException {
		// 1. check weather the request is valid
		request.validate();
		LOG.info("Inside update Employee");
		Integer empid = request.getId();

		// 2.Check Weather employee is present in database
		Employee emp = empDAO.getById(Employee.class, empid);
		if (null == emp) {
			LOG.error("employee does not exsist", empid);
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}

		// 3.update the employee

		Employee employee = new Employee();
		BeanUtils.copyProperties(request, employee);
		empDAO.update(employee);
		LOG.debug("Employee data updated:", employee);

	}

	@Override
	public Employee getEmployee(IdRequest request) throws EMPException {
		Employee dbId = empDAO.getById(Employee.class, request.getId());
		if (dbId == null) {
			LOG.error("Invalid Id", request.getId());
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}
		Integer id=request.getId();
		Employee Dbid=empDAO.getEmployee(id);
		if(Dbid==null)
		{
			LOG.error("Invalid Id", request.getId());
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}
		return empDAO.getById(Employee.class, request.getId());

	}

	@Override
	public Employee getEmployeebyname(EmployeeRequest request) throws EMPException {
		// TODO 1.validate
		request.validate();
		String name = request.getFirstName();
		LOG.info("inside getEmployeebyname");

		// TODO 2. check weather the employee is present
		Employee e = empDAO.getEmployeebyname(name);
		if (null == e) {
			LOG.error("Employee does not exsist with this name :", name);
			throw new EMPException(EMPError.EMP_ERR_USERNAME_INVALID);
		}
		// TODO 3.get the details of employee with the given name
		return e;
	}

	@Override
	public Employee SearchEmployee(EmployeeRequest request) throws EMPException {
		// TODO Auto-generated method stub
		String name = request.getFirstName();
		Employee emp = empDAO.getEmployeebyname(name);

		if (emp==null) {
			LOG.error("Employee with the name does not exsist", name);
			throw new EMPException(EMPError.EMP_ERR_USERNAME_INVALID);
		}
            return emp;

	}

	@Override
	public List<Employee> getEmployeeRecord() {

		List<Employee> emp = empDAO.getEmployeebyDate();
		System.out.println(emp);
		return emp;

	}

}
