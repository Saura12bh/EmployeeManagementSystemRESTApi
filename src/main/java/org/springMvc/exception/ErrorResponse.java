package org.springMvc.exception;

public class ErrorResponse {  //DTO data transion object

	private int status;
	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
