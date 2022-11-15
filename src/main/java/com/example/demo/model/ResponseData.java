package com.example.demo.model;

import lombok.Data;

@Data
public class ResponseData {
	
	private String fileName;
	private String downloadUrl;
	private String fileType;
	private Long fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public ResponseData(String fileName, String downloadUrl, String fileType, Long fileSize) {
		super();
		this.fileName = fileName;
		this.downloadUrl = downloadUrl;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}
	public ResponseData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseData [fileName=" + fileName + ", downloadUrl=" + downloadUrl + ", fileType=" + fileType
				+ ", fileSize=" + fileSize + "]";
	}
	
	

}
