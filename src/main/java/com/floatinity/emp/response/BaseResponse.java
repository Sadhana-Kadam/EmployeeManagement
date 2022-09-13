package com.floatinity.emp.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.floatinity.emp.enums.APIStatus;
import com.floatinity.emp.exception.EMPError;

/**
 * @author Floatinity
 *
 */
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private APIStatus status;

	private Set<EMPError> empErrors = new HashSet<EMPError>();

	private Object data;

	public BaseResponse() {
		this.status = APIStatus.SUCCESS;
	}

	public BaseResponse(APIStatus success) {
		this.status = APIStatus.SUCCESS;
	}

	public static BaseResponse getSuccessResponse() {
		BaseResponse response = new BaseResponse();
		response.setStatus(APIStatus.SUCCESS);
		return response;
	}

	public static BaseResponse getSuccessResponse(String info) {
		BaseResponse response = new BaseResponse();
		response.setStatus(APIStatus.SUCCESS);
		return response;
	}

	public static BaseResponse getFailureResponse() {
		BaseResponse response = new BaseResponse();
		response.setStatus(APIStatus.FAILED);
		return response;
	}

	public static BaseResponse getFailureResponse(EMPError error) {
		BaseResponse response = getFailureResponse();
		response.setGMSError(error);
		return response;
	}

	public static BaseResponse getFailureResponse(EMPError error, String info) {
		BaseResponse response = getFailureResponse();
		response.setGMSError(error);
		return response;
	}

	public static BaseResponse getFailureResponse(Set<EMPError> error) {
		BaseResponse response = getFailureResponse();
		response.setCidErrors(error);
		return response;
	}

	public static BaseResponse getFailureResponse(String message) {
		BaseResponse response = new BaseResponse();
		response.setStatus(APIStatus.SUCCESS);
		return response;
	}

	public APIStatus getStatus() {
		return status;
	}

	public void setStatus(APIStatus status) {
		this.status = status;
	}

	public Set<EMPError> getCidErrors() {
		return empErrors;
	}

	public void setCidErrors(Set<EMPError> cidErrors) {
		this.empErrors = cidErrors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setGMSError(EMPError cidError) {
		this.empErrors.add(cidError);
	}

}
