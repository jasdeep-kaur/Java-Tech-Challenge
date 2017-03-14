package ravi.model;

public class FailureResponse {
	private boolean success;
	private String errorCode;
	private String message;
	
	public FailureResponse(boolean success, String errorCode, String message) {
		
		this.success = success;
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
