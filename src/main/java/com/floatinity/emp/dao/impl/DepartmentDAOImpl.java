package com.floatinity.emp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.floatinity.emp.dao.IDepartmentDAO;
import com.floatinity.emp.dao.beans.Department;

@Repository
public class DepartmentDAOImpl extends GenericDAOImpl<Department> implements IDepartmentDAO {

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public Department getDepartment(String name) {
		Department d = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Department.class);
		criteria.add(Restrictions.eq("deptName", name));
        List<Department> dept = criteria.list();
		if (!dept.isEmpty()) {
			d = dept.get(0);
		}
		return d;

	}

}
