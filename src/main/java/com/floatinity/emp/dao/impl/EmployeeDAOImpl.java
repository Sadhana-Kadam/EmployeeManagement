package com.floatinity.emp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.floatinity.emp.dao.IEmployeeDAO;
import com.floatinity.emp.dao.beans.Employee;
import com.floatinity.emp.request.EmployeeRequest;

@Repository
public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Employee getEmployeeByEmail(String email) {
		Employee employee = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("email", email));
		List<Employee> employees = criteria.list();
		if (!employees.isEmpty()) {
			employee = employees.get(0);
		}
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Employee getEmployeebyname(String name) {
		Employee e = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Employee.class);
		c.add(Restrictions.eq("firstName", name));
		c.add(Restrictions.ne("Status",Boolean.FALSE));
		List<Employee> emp = c.list();
		if (!emp.isEmpty()) {
			e = emp.get(0);
		}

		return e;

	}

	public void searchEmployee(String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Employee.class);
		c.add(Restrictions.eq("firstName", name));
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		Employee employee=null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.ne("status",Boolean.FALSE));
		List<Employee> emp = criteria.list();
		if (!emp.isEmpty()) {
			employee = emp.get(0);
		}
		return employee;
	}

//	@Override
//	@Transactional
//	public Employee getEmployeebyname(String name) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(Employee.class);
//      criteria.add(Restrictions.eq("firstName",name);
//		  return (Employee)criteria.list();
//
//		
//	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Employee> getEmployeebyDate() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("dateofJoining"));
		criteria.setMaxResults(3);
		return criteria.list();

	}

}
