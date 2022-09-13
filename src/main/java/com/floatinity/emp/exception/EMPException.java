package com.floatinity.emp.exception;

import java.util.HashSet;
import java.util.Set;

import com.floatinity.core.exception.FLOException;

public class EMPException extends FLOException {

	private static final long serialVersionUID = 1L;

	private Set<EMPError> empErrors = new HashSet<EMPError>();

	private String info;

	public EMPException(Throwable cause) {
		super(cause);
	}

	public EMPException(String message) {
		super(message);
	}

	public EMPException(EMPError cidErrors) {
		super(cidErrors.getErrKey());
		this.empErrors.add(cidErrors);
	}

	public EMPException(Set<EMPError> cidErrors) {
		super("");
		this.empErrors = cidErrors;
	}

	public EMPException(EMPError cidError, String info) {
		super(cidError.getErrKey());
		this.empErrors.add(cidError);
		this.setInfo(info);
	}

	public Set<EMPError> getCidErrors() {
		return empErrors;
	}

	public void setCidErrors(Set<EMPError> cidErrors) {
		this.empErrors = cidErrors;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
