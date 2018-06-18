/**
 * 
 */
package com.sapient.error;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Invalid Number")
@Description("Error Code will be display.")
public class ErrorCodeResponse {

	private String errorCode;
	private String message;

	/**
	 * @param errorCode
	 * @param message
	 */
	public ErrorCodeResponse(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
