package com.ril.fb.exception;

public class ShoppingcartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7256380258089047053L;

	public ShoppingcartException() {
	}

	public ShoppingcartException(String message) {
		super(message);
	}

	public ShoppingcartException(Long cartId) {
		super(String.format("No details is found with cartId [%d]", cartId));
	}

}
