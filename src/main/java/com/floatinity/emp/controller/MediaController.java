package com.floatinity.emp.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.MediaRequest;
import com.floatinity.emp.response.BaseResponse;
import com.floatinity.emp.service.*;

@Controller
@RequestMapping(value = "/file")
public class MediaController {

	@Autowired
	private IMediaService mediaService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("rq") String request)
			throws EMPException, IOException, Exception {
		BaseResponse response = new BaseResponse();
		MediaRequest request1 = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			request1 = mapper.readValue(request, MediaRequest.class);
		} catch (Exception e) {
			throw new EMPException(EMPError.EMP_ERR_INVALID_PAYLOAD);
		}
		response.setData(mediaService.uploadFile(file, request1));
		return response;
	}
//
//		@RequestMapping(value = "/get", method = RequestMethod.POST)
//		@ResponseBody
//		public BaseResponse getFile(@RequestBody IdRequest request) throws GMSException {
//			BaseResponse response = new BaseResponse();
//			response.setData(mediaSevice.getFileDetails(request));
//			return response;
//		}
//
//		@RequestMapping(value = "/download", method = RequestMethod.GET)
//		@ResponseBody
//		public void downloadFile(HttpServletResponse response, @RequestParam("fn") String fileName)
//				throws GMSException, IOException, Exception {
//			mediaSevice.downloadFile(response, fileName);
//		}
//
//		@RequestMapping(value = "/delete", method = RequestMethod.POST)
//		@ResponseBody
//		public BaseResponse deleteFile(@RequestBody IdRequest request) throws GMSException {
//			BaseResponse response = new BaseResponse();
//			mediaSevice.deleteFile(request);
//			return response;
//		}
//
//	}
//
//
}
