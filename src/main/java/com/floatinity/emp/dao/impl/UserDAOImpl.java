package com.floatinity.emp.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.floatinity.emp.dao.IUserDAO;
import com.floatinity.emp.dao.beans.User;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User> implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void create(User request) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("firstName", request.getFirstName()));
		criteria.list();

	}

}
