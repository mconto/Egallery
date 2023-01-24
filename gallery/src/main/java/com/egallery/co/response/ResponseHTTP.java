package com.egallery.co.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
public class ResponseHTTP implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private Object response;
	
	public ResponseHTTP(int i, HttpStatus.Series successful, String already_reported) {
		
	}
	
	public ResponseHTTP(int status, Object response) {
		super();
		this.status = status;
		this.response = response;
	}
		
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	

}
