package com.springboot.rest.example.util;

/**
 * Response data of the rest services that does not return entities. Usually represents the status of the operation.
 */
public class RestResponse {
	private String message;
	private String status;
	private String error;
	
	public RestResponse(String message, String status, String error) {
		super();
		this.message = message;
		this.status = status;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
