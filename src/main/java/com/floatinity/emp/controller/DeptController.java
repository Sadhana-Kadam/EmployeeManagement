package com.floatinity.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.DeptRequest;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.response.BaseResponse;
import com.floatinity.emp.service.IDepartmentService;

@Controller
@RequestMapping(value = "/department")
public class DeptController {

	@Autowired
	private IDepartmentService dept;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse createDept(@RequestBody DeptRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		dept.createDepartment(request);
		return response;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse updateDept(@RequestBody DeptRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		dept.updateDepartment(request);
		return response;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse deleteDept(@RequestBody DeptRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		dept.deleteDepartment(request);
		return response;

	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse getdept(@RequestBody IdRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		dept.getDepartment(request);
		return response;
	}

	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse getdept(@RequestBody DeptRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		dept.getAllDepartment();
		return response;
	}
}
