package com.floatinity.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.request.LeaveRequest;
import com.floatinity.emp.response.BaseResponse;
import com.floatinity.emp.service.ILeaveService;

@Controller
@RequestMapping(value = "/leave")
public class LeaveController {

	@Autowired
	ILeaveService leaveservice;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse createleave(@RequestBody LeaveRequest request) {
		BaseResponse response = new BaseResponse();
		leaveservice.createLeave(request);
		return response;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse updateLeave(@RequestBody LeaveRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		leaveservice.updateLeave(request);
		return response;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse deleteLeave(@RequestBody IdRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		leaveservice.deleteLeave(request);
		return response;

	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse getLeave(@RequestBody IdRequest request) {
		BaseResponse response = new BaseResponse();
		response.setData(leaveservice.getleave(request));
		return response;

	}

	@RequestMapping(value = "/all/get", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse getAllLeaves() {
		BaseResponse response = new BaseResponse();
		response.setData(leaveservice.getAllleaves());
		return response;

	}
	
	@RequestMapping(value = "/employee/leave/get", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse getemployeeleaves(@RequestBody LeaveRequest request) throws EMPException {
		BaseResponse response = new BaseResponse();
		response.setData(leaveservice.getemployeeLeave(request));
		return response;
}
}