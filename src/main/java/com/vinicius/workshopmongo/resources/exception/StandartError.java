package com.vinicius.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandartError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandartError() {
	}

	public StandartError(Long timeStamp, Integer status, String error, String messagee, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}