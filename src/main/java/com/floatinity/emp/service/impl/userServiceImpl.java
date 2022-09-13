package com.floatinity.emp.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floatinity.emp.dao.IUserDAO;
import com.floatinity.emp.dao.beans.User;
import com.floatinity.emp.service.IUserService;

@Service
public class userServiceImpl implements IUserService {

	private static final Logger LOG = LogManager.getFormatterLogger(userServiceImpl.class);

	@Autowired
	private IUserDAO userDAO;

	@Override
	public void createUser(User request) {
		LOG.info("inside create user");
		userDAO.create(request);

	}

}
