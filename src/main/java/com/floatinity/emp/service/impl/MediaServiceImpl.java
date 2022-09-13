package com.floatinity.emp.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.floatinity.emp.dao.IMediaDAO;
import com.floatinity.emp.dao.beans.Files;
import com.floatinity.emp.exception.EMPError;
import com.floatinity.emp.exception.EMPException;
import com.floatinity.emp.request.IdRequest;
import com.floatinity.emp.request.MediaRequest;
import com.floatinity.emp.response.FileResponse;
import com.floatinity.emp.service.IMediaService;


@Service
public class MediaServiceImpl implements IMediaService {

	private static final Logger LOG = LogManager.getLogger(MediaServiceImpl.class);

//	@Value("${file.upload.path}")
	private String filePath;

	@Autowired
	private IMediaDAO mediadao;

	
	@Override
	public FileResponse uploadFile(MultipartFile file, MediaRequest fileRequest)
			throws IOException, Exception, EMPException {
		// TODO 1) check the file is empty
		LOG.info("Inside upload file");
		if (file.isEmpty()) {
			LOG.debug("File is empty");
			throw new EMPException(EMPError.EMP_ERR_FILE_EMPTY_);
		}
		//TODO upload file
		FileResponse fileReponse = new FileResponse();
		String fileName = FilenameUtils.normalize(file.getOriginalFilename());
		String sysFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "-" + System.currentTimeMillis()
				+ fileName.substring(fileName.lastIndexOf("."));
		BufferedOutputStream stream = null;
		try {
			byte[] bytes = file.getBytes();
			File dir = new File(filePath);
			if (!dir.exists())
				dir.mkdirs();
			File desinationFile = new File(
					dir.getAbsolutePath() + File.separator + FilenameUtils.normalize(sysFileName));
			stream = new BufferedOutputStream(new FileOutputStream(desinationFile));
			stream.write(bytes);
		} catch (Exception e) {
			LOG.error("Error saving media file to {}, error {}", filePath, e);
			throw e;
		} //finally {
			// CommonUtil.closeStreams(stream);
		//}
		//TODO  file upload is successful, create entry in db and return fileId
		
		Files files = new Files();
		
		files.setFileName(fileName);
		files.setUniqueFilename(sysFileName);
		files.setFilePath(filePath);
		files.setFileSize(file.getSize());
		files.setFileContentType(file.getContentType());
		files.setFiletype(fileRequest.getFileType());
		Integer fileId = mediadao.save(files);

		fileReponse.setFileId(fileId);
		
		return fileReponse;
	}

	

	@Override
	public void downloadFile(HttpServletResponse response, String fileName) throws EMPException {
		// TODO Auto-generated method stub

	}

	@Override
	public File getFileDetails(IdRequest request) throws EMPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFile(IdRequest request) throws EMPException {
		// TODO Auto-generated method stub

	}

}
