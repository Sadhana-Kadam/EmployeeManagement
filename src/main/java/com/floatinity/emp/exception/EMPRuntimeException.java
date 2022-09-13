package com.floatinity.emp.exception;

/**
 * @author Floatinity
 *
 */
public class EMPRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public EMPRuntimeException(Throwable cause) {
		String msg = cause.getMessage();
		if (msg == null) {
			msg = cause.getClass().getName();
		}
		this.message = msg;
	}

	public EMPRuntimeException(String msg) {
		this.message = msg;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
