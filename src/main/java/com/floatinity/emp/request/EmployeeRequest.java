package com.floatinity.emp.request;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.floatinity.core.object.FLOUtil;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;

@SuppressWarnings("serial")
public class EmployeeRequest extends IdRequest {

	private String firstName;

	private String middleName;

	private String lastName;

	private String department;

	private String dateofBirth;

	private String dateofJoinning;

	private String email;

	private String phNo;

	private String mbNo;

	private String createdBy;

	private String updatedBy;

	private String profilePic;

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDateofJoinning() {
		return dateofJoinning;
	}

	public void setDateofJoinning(String dateofJoinning) {
		this.dateofJoinning = dateofJoinning;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getMbNo() {
		return mbNo;
	}

	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}

	@Override
	public void validate() throws EMPException {
		Set<EMPError> gmsErrors = new HashSet<EMPError>();
		if (StringUtils.isEmpty(this.firstName)) {
			gmsErrors.add(EMPError.EMP_ERR_USERNAME_INVALID);
		}
		if (!FLOUtil.isNullOrEmpty(gmsErrors)) {
			throw new EMPException(gmsErrors);
		}

	}

}
