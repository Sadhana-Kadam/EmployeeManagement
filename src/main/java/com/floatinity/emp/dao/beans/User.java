package com.floatinity.emp.dao.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class User {
	
//	@Column(name = "f_name")
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
