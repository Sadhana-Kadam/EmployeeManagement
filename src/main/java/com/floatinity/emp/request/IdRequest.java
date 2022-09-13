package com.floatinity.emp.request;

import java.util.HashSet;
import java.util.Set;

import com.floatinity.core.object.FLOUtil;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;

/**
 * @author Shree
 *
 */
public class IdRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IdRequest [id=" + id + "]";
	}

	@Override
	public void validate() throws EMPException {
		Set<EMPError> empErrors = new HashSet<EMPError>();
		if (this.id == null) {
			empErrors.add(EMPError.EMP_ERR_INVALID_ID);
		}
		if (!FLOUtil.isNullOrEmpty(empErrors)) {
			throw new EMPException(empErrors);
		}
	}

}
