package com.floatinity.emp.dao.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission {
	@Id
	@Column(name = "permission_id")
	private Integer PermissionId;

	@Column(name = "permission_name")
	private String PermissonName;

	@Column(name = "permission_description")
	private String PermissionDiscription;

	@Column(name = "entity")
	private String entity;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Integer getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(Integer permissionId) {
		PermissionId = permissionId;
	}

	public String getPermissonName() {
		return PermissonName;
	}

	public void setPermissonName(String permissonName) {
		PermissonName = permissonName;
	}

	public String getPermissionDiscription() {
		return PermissionDiscription;
	}

	public void setPermissionDiscription(String permissionDiscription) {
		PermissionDiscription = permissionDiscription;
	}
}
