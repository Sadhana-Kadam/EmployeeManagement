package com.floatinity.emp.dao.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Integer id;

	@Column(name = "f_name")
	private String firstName;

	@Column(name = "m_name")
	private String middleName;

	@Column(name = "l_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "m_no")
	private String mbno;

	@Column(name = "ph_no")
	private String phnno;

	@Column(name = "department_name")
	private String department;

	@Column(name = "date_of_birth")
	private String dateofBirth;

	@Column(name = "date_of_joinning")
	private String dateofJoining;

	@Column(name = "created_ts")
	private Timestamp createdTs;

	@Column(name = "updated_ts")
	private Timestamp updatedts;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "status")
	private boolean status;

	@Column(name = "profilePic")
	private String profilePic;

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getDateofJoining() {
		return dateofJoining;
	}

	public void setDateofJoining(String dateofJoining) {
		this.dateofJoining = dateofJoining;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public Timestamp getUpdatedts() {
		return updatedts;
	}

	public void setUpdatedts(Timestamp updatedts) {
		this.updatedts = updatedts;
	}

	public String getMbno() {
		return mbno;
	}

	public void setMbno(String mbno) {
		this.mbno = mbno;
	}

	public String getPhnno() {
		return phnno;
	}

	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", mbno=" + mbno + ", phnno=" + phnno + ", department=" + department
				+ ", dateofBirth=" + dateofBirth + ", dateofJoining=" + dateofJoining + ", createdTs=" + createdTs
				+ ", updatedts=" + updatedts + ", updatedBy=" + updatedBy + ", createdBy=" + createdBy + "]";
	}

}
