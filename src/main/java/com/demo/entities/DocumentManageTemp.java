package com.demo.entities;

import java.util.Date;

public class DocumentManageTemp {

	private int id;
	private String fileName;
	private String filePath;
	private String fileName2;
	private String status;
	private Date registerDate;
	private String memo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getFileName2() {
		return fileName2;
	}
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}
	public DocumentManageTemp(int id, String fileName, String filePath, String fileName2, String status,
			Date registerDate, String memo) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileName2 = fileName2;
		this.status = status;
		this.registerDate = registerDate;
		this.memo = memo;
	}
	public DocumentManageTemp() {
		super();
	}
	@Override
	public String toString() {
		return "DocumentManageTemp [id=" + id + ", fileName=" + fileName + ", filePath=" + filePath + ", fileName2="
				+ fileName2 + ", status=" + status + ", registerDate=" + registerDate + ", memo=" + memo + "]";
	}





}
