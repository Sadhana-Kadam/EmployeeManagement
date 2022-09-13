package com.floatinity.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.floatinity.emp.dao.beans.User;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.response.BaseResponse;
import com.floatinity.emp.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse createUser(@RequestBody User request) throws EMPException {
		BaseResponse reponse = new BaseResponse();
		userService.createUser(request);
		return reponse;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String getHello() throws EMPException {

		return "Hello world";
	}

}
