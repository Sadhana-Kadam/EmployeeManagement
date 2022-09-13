package com.floatinity.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.EmployeeRequest;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.response.BaseResponse;
import com.floatinity.emp.service.IEmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService empservice;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse createEmployee(@RequestBody EmployeeRequest request) throws EMPException {
		BaseResponse reponse = new BaseResponse();
		empservice.createEmployee(request);
		return reponse;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse deleteEmployee(@RequestBody IdRequest request) throws EMPException {
		BaseResponse reponse = new BaseResponse();
		empservice.deleteEmployee(request);
		return reponse;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse updateEmployee(@RequestBody EmployeeRequest request) throws EMPException {
		BaseResponse reponse = new BaseResponse();
		empservice.updateEmployee(request);
		return reponse;
	}

	@RequestMapping(value = "/get"+"/id", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse getEmployee(@RequestBody IdRequest request) throws EMPException {
		BaseResponse reponse = new BaseResponse();
		reponse.setData(empservice.getEmployee(request));
		return reponse;
	}

	@RequestMapping(value = "/get/name", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse getEmployeebyname(@RequestBody EmployeeRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		response.setData(empservice.getEmployeebyname(request));
		return response;

	}

	@RequestMapping(value = "/search/employee", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse getEmployee(@RequestBody EmployeeRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		response.setData(empservice.SearchEmployee(request));
		return response;
	}

	@RequestMapping(value = "/record", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse getEmployeeRecord() {
		BaseResponse response = new BaseResponse();
		response.setData(empservice.getEmployeeRecord());
		return response;

	}
}