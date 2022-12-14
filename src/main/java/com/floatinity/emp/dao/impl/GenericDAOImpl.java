package com.floatinity.emp.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.floatinity.emp.dao.IGenericDAO;

public abstract class GenericDAOImpl<T> implements IGenericDAO<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	private static final String GET_ID_METHOD_NAME = "getId";

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <E> E getById(Class<?> tableToQuery, Integer id) {
		return (E) this.getSession().get(tableToQuery, id);
	}

	@Transactional
	@Override
	public int deleteByIDs(Class<?> tableToQuery, Set<Integer> ids) {
		String hql = "DELETE from " + tableToQuery.getName() + " WHERE id in :ids";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setParameterList("ids", ids);
		return query.executeUpdate();
	}

	@Transactional
	@Override
	public int deleteByID(Class<?> tableToQuery, Integer id) {
		String hql = "DELETE from " + tableToQuery.getName() + " WHERE id =:ids";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setParameter("ids", id);
		return query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public <E> List<E> getAll(Class<?> tableToQuery) {
		return this.getSession().createCriteria(tableToQuery).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <E> List<E> get(Criteria criteria) {
		List<E> objects = null;
		if (criteria != null) {
			objects = criteria.list();
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <E> List<E> get(String hql) {
		List<E> objects = null;
		if (!StringUtils.isEmpty(hql)) {
			objects = this.getSession().createQuery(hql).list();
		}
		return objects;
	}

	@Transactional
	@Override
	public <E> Integer save(E entity) {
		Integer id = null;
		try {
			Method method = entity.getClass().getMethod(GET_ID_METHOD_NAME);
			id = (Integer) method.invoke(entity);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		if (id != null && id > 0) {
			this.getSession().update(entity);
		} else {
			id = (Integer) this.getSession().save(entity);
		}
		return id;
	}

	@Transactional
	@Override
	public <E> void update(E entity) {
		this.getSession().update(entity);
	}

	@Transactional
	@Override
	public <E> boolean delete(E entity) {
		this.getSession().delete(entity);
		return true;
	}

	@Override
	@Transactional
	public int getCount(Class<?> tableToQuery, Criteria criteria) {
		Session session = this.getSession();
		if (criteria == null) {
			criteria = session.createCriteria(tableToQuery);
			criteria.setProjection(Projections.rowCount());
		}
		Object countObj = criteria.uniqueResult();
		int count = 0;
		if (countObj != null) {
			count = ((Long) countObj).intValue();
		}
		return count;
	}

	@Override
	@Transactional
	public int getCount(Class<?> tableToQuery) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(tableToQuery);
		criteria.setProjection(Projections.rowCount());
		return this.getCount(tableToQuery, criteria);
	}

	@Override
	@Transactional
	public boolean executeQuery(String hql) {
		boolean isExecuted = false;
		if (!StringUtils.isEmpty(hql)) {
			Query query = this.getSession().createQuery(hql);
			query.executeUpdate();
			isExecuted = true;
		}
		return isExecuted;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <E> List<E> getByIds(Class<?> tableToQuery, Set<Integer> ids) {
		Criteria criteria = this.getSession().createCriteria(tableToQuery);
		criteria.add(Restrictions.in("id", ids));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<E>) (List<?>) criteria.list();
	}

}
