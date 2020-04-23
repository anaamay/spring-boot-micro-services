package com.ril.fb.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ShoppingcartControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ShoppingcartException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleDetailsNotFoundException(ShoppingcartException exception, WebRequest request) {
		return new ResponseEntity<>(setMessageBody(exception), HttpStatus.NOT_FOUND);
	}

	private static Map<String, Object> setMessageBody(RuntimeException exception) {
		Map<String, Object> messageBody = new HashMap<>();
		messageBody.put("timestamp", LocalDateTime.now());
		messageBody.put("message", exception.getMessage());
		return messageBody;
	}

}
