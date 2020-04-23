package com.ril.fb.exception;

public class OrderServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8366646336950490146L;

	public OrderServiceException() {
	}

	public OrderServiceException(String message) {
		super(String.format(message));
	}

}
