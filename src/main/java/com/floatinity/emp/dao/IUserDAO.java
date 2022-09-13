package com.floatinity.emp.dao;

import com.floatinity.emp.dao.beans.User;

public interface IUserDAO extends IGenericDAO<User>{

	public void create(User request);

}
