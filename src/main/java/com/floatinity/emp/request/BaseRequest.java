package com.floatinity.emp.request;

import java.io.Serializable;

import com.floatinity.emp.exception.EMPException;

/**
 * @author Shree
 *
 */
public abstract class BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract void validate() throws EMPException;

}