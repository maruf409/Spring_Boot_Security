package com.spring.boot.security.studentModel;

public class studentModel {

	private Integer studentId;
	private String name;
	private Integer batchId;

	public studentModel(int studentId, String name, int batchId) {
		this.studentId = studentId;
		this.name = name;
		this.batchId = batchId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

}
