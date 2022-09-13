package com.floatinity.emp.request;

import java.util.HashSet;
import java.util.Set;

import com.floatinity.core.object.FLOUtil;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;

public class NameRequest extends BaseRequest{

	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void validate() throws EMPException {
		// TODO Auto-generated method stub
		Set<EMPError> empErrors = new HashSet<EMPError>();
		if (this.name == null) {
			empErrors.add(EMPError.EMP_ERR_USERNAME_INVALID);
		}
		if (!FLOUtil.isNullOrEmpty(empErrors)) {
			throw new EMPException(empErrors);
		}
		
	}

}
