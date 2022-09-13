package com.floatinity.emp.dao.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.floatinity.emp.enums.FileType;

@Entity
@Table(name = "files")
public class Files {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fileId")
	private Integer fileId;

	@Column(name = "fileName")
	private String fileName;

	@Column(name = "filePath")
	private String filePath;

	@Column(name = "fileType")
	private FileType filetype;

	@Column(name = "fileContentType")
	private String fileContentType;

	@Column(name = "fileSize")
	private long fileSize;

	@Column(name = "created_ts")
	private Timestamp createdTs;

	@Column(name = "updated_ts")
	private Timestamp updatedTs;
	
	@Column(name ="uniquefilename")
	private String uniqueFilename;

	public String getUniqueFilename() {
		return uniqueFilename;
	}

	public void setUniqueFilename(String uniqueFilename) {
		this.uniqueFilename = uniqueFilename;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public FileType getFiletype() {
		return filetype;
	}

	public void setFiletype(FileType filetype) {
		this.filetype = filetype;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long l) {
		this.fileSize = l;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public Timestamp getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Timestamp updatedTs) {
		this.updatedTs = updatedTs;
	}
}
