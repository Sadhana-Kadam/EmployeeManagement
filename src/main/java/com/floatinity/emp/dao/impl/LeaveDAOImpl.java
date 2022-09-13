package com.floatinity.emp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.floatinity.emp.dao.ILeaveDAO;
import com.floatinity.emp.dao.beans.Leave;

@Repository
public class LeaveDAOImpl extends GenericDAOImpl<Leave> implements ILeaveDAO {

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Leave> getleavebyempId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Leave.class);
		criteria.add(Restrictions.eq("empId", id));
		return criteria.list();

	}

}
