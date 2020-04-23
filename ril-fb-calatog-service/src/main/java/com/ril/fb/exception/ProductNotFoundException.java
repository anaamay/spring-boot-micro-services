package com.ril.fb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 7170425205971633377L;

	public ProductNotFoundException(String product) {
		super("No such " + product + " product found");
	}
}
