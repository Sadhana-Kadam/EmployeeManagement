package com.floatinity.emp.request;

import com.floatinity.emp.enums.*;
import com.floatinity.emp.exception.*;

public class MediaRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;

	private FileType fileType;

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	@Override
	public void validate() throws EMPException {

	}

	@Override
	public String toString() {
		return "FileRequest [fileType=" + fileType + "]";
	}

	

}
