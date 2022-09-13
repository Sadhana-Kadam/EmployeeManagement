package com.floatinity.emp.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.request.MediaRequest;
import com.floatinity.emp.response.FileResponse;

public interface IMediaService {
	
	public FileResponse uploadFile(MultipartFile file, MediaRequest fileRequest)
	
			throws IOException, Exception, EMPException;

	public void downloadFile(HttpServletResponse response, String fileName) throws EMPException;

	public File getFileDetails(IdRequest request) throws EMPException;

	public void deleteFile(IdRequest request) throws EMPException;

}
