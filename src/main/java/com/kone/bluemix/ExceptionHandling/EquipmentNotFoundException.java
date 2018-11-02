package com.kone.bluemix.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipmentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	
	public EquipmentNotFoundException(String exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
}
