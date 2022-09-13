package com.floatinity.emp.dao;

import java.util.List;

import com.floatinity.emp.dao.beans.Leave;

public interface ILeaveDAO extends IGenericDAO<Leave> {
	
	public List<Leave> getleavebyempId(int id);

}
