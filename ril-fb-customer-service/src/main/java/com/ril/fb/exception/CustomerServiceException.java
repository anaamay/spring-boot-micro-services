package com.ril.fb.exception;

public class CustomerServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6632973310891803832L;

	public CustomerServiceException() {
	}

	public CustomerServiceException(String message) {
		super(message);
	}

	public CustomerServiceException(Long message) {
		super(String.format("No customer details is found with customerId:[%d]", message));
	}

}
