package com.floatinity.emp.dao.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaves")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leaveid")
	private Integer id;

	@Column(name = "LeaveReason")
	private String leaveReason;

	@Column(name = "LeaveStartDate")
	private Timestamp leaveStartDate;

	
	@Column(name = "LeaveEndDate")
	private Timestamp leaveEndDate;

	@Column(name = "LeaveType")
	private String leaveType;

	@Column(name = "LeaveStatus")
	private String leaveStatus;

	@Column(name = "emp_id")
	private Integer empId;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Timestamp getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Timestamp leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Timestamp getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Timestamp leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

}
