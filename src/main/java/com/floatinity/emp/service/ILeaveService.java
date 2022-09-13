package com.floatinity.emp.service;

import java.util.List;

import com.floatinity.emp.dao.beans.Leave;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.request.LeaveRequest;

public interface ILeaveService {

	public Leave getleave(IdRequest request);

	public void updateLeave(LeaveRequest request) throws EMPException;

	public void createLeave(LeaveRequest request);

	public void deleteLeave(IdRequest request) throws EMPException;

	public List<Leave> getAllleaves();
	
	public List<Leave> getemployeeLeave(LeaveRequest request) throws EMPException;
	
}
