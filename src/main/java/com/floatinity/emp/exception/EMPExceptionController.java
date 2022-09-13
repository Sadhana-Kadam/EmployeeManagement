package com.floatinity.emp.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.floatinity.emp.response.BaseResponse;

/**
 * @author Floatinity
 *
 */
@ControllerAdvice
public class EMPExceptionController {

	private static final Logger LOGGER = LogManager.getLogger(EMPExceptionController.class);

	@ExceptionHandler(value = HibernateException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	BaseResponse handleException(HibernateException dbException) {
		LOGGER.error("Error in controller", dbException);
		return BaseResponse.getFailureResponse(EMPError.EMP_DB_ERROR);
	}

	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	BaseResponse handleException(Throwable exception) {
		LOGGER.error("Error in controller", exception);
		return BaseResponse.getFailureResponse(EMPError.EMP_APPLICATION_ERROR);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	BaseResponse handleException(HttpMessageNotReadableException exception) {
		LOGGER.error("Error in controller", exception);
		return BaseResponse.getFailureResponse(EMPError.EMP_ERR_INVALID_PAYLOAD);
	}

	@ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ResponseBody
	BaseResponse handleException(HttpMediaTypeNotSupportedException exception) {
		LOGGER.error("Error in controller", exception);
		return BaseResponse.getFailureResponse(EMPError.EMP_ERR_INVALID_PAYLOAD);
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	BaseResponse handleException(HttpRequestMethodNotSupportedException exception) {
		LOGGER.error("Error in controller", exception);
		return BaseResponse.getFailureResponse(EMPError.EMP_ERR_INVALID_HTTP_METHOD);
	}

	@ExceptionHandler(value = EMPException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	BaseResponse handleException(EMPException cidException) {
		LOGGER.error("Error in controller", cidException);
		return BaseResponse.getFailureResponse(cidException.getCidErrors());
	}

	@ExceptionHandler(value = AccessDeniedException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	BaseResponse handleException(AccessDeniedException permissionError) {
		LOGGER.error("Error in controller", permissionError);
		return BaseResponse.getFailureResponse(EMPError.EMP_ERR_PERMISSION_DENIED, permissionError.getMessage());
	}
}
