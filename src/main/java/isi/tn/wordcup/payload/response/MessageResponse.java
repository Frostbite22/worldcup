package isi.tn.wordcup.payload.response;

public class MessageResponse {

	private boolean success;
	private String detail;
	
	private String message;

	public MessageResponse(boolean success, String detail, String message) {
		super();
		this.success = success;
		this.detail = detail;
		this.message = message;
	}

	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
