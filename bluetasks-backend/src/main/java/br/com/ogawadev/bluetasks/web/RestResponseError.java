package br.com.ogawadev.bluetasks.web;


import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import lombok.Getter;

@Getter
public class RestResponseError {
	String error;
	
	private RestResponseError() {
		
	}
	
	public static RestResponseError fromValidationError(Errors errors) {
		RestResponseError resp = new RestResponseError();
		StringBuilder sb = new StringBuilder();
		
		for(ObjectError error : errors.getAllErrors()) {
			sb.append(error.getDefaultMessage()).append(". ");
		}
		
		resp.error = sb.toString();
		
		return resp;
	}
	
	public static RestResponseError fromMessage(String message) {
		RestResponseError resp = new RestResponseError();
		resp.error = message;
		return resp;
	}
}
