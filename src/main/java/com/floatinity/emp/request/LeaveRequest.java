package com.floatinity.emp.request;

import java.sql.Timestamp;

public class LeaveRequest extends IdRequest {

	private Integer empId;

	private String leaveReason;

	private Timestamp LeaveStartDate;

	private Timestamp LeaveEndDate;
	
	private String leaveType;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Timestamp getLeaveStartDate() {
		return LeaveStartDate;
	}

	public void setLeaveStartDate(Timestamp leaveStartDate) {
		LeaveStartDate = leaveStartDate;
	}

	public Timestamp getLeaveEndDate() {
		return LeaveEndDate;
	}

	public void setLeaveEndDate(Timestamp leaveEndDate) {
		LeaveEndDate = leaveEndDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

}
