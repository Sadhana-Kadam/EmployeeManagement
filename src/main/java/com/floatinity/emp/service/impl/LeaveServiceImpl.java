package com.floatinity.emp.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floatinity.emp.dao.ILeaveDAO;
import com.floatinity.emp.dao.beans.Leave;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.request.LeaveRequest;
import com.floatinity.emp.service.ILeaveService;

@Service
public class LeaveServiceImpl implements ILeaveService {

	private static final Logger LOG = LogManager.getLogger(LeaveServiceImpl.class);

	@Autowired
	private ILeaveDAO leavedao;

	@Override
	public void createLeave(LeaveRequest request) {
		Leave leaveEntity = new Leave();
		leaveEntity.setLeaveStatus("Not Approved");
		BeanUtils.copyProperties(request, leaveEntity);
		Integer leave = leavedao.save(leaveEntity);
		LOG.info("leave added", leave);

	}

	@Override
	public void updateLeave(LeaveRequest request) throws EMPException {

		// check weather the leave exsist.
		LOG.info("Inside update leave");
		Integer id = request.getId();
		Leave leaves = leavedao.getById(Leave.class, id);

		if (null == leaves) {
			LOG.error("INVALID LEAVE", id);
			throw new EMPException(EMPError.EMP_ERR_INVALID_LEAVE_);
		}

		// update the leave
		Leave leave = new Leave();
		BeanUtils.copyProperties(request, leave);
		leavedao.update(leave);
		LOG.debug("Leave updated", id);
	}

	@Override
	public void deleteLeave(IdRequest request) throws EMPException {
		// TODO Auto-generated method stub
		LOG.info("Inside Delete Leave");
		Integer id = request.getId();
		Leave leave = leavedao.getById(Leave.class, id);

		if (null == leave) {
			LOG.error("INVALID ID", id);
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}
		leavedao.deleteByID(Leave.class, id);
		LOG.info("LEAVE DELETED");
	}

	@Override
	public Leave getleave(IdRequest request) {

		// TODO Auto-generated method stub
		return leavedao.getById(Leave.class, request.getId());
	}

	@Override
	public List<Leave> getAllleaves() {

		return leavedao.getAll(Leave.class);
	}

	@Override
	public List<Leave> getemployeeLeave(LeaveRequest request) throws EMPException{
		//  check the empid
		Integer empID=request.getEmpId();
		List<Leave> leave=leavedao.getleavebyempId(empID);
		if(leave.isEmpty())
		{
			LOG.error("INVALID Emp ID",empID);
			throw new EMPException(EMPError.EMP_ERR_INVALID_ID);
		}

		return leave;
	}

	
}
