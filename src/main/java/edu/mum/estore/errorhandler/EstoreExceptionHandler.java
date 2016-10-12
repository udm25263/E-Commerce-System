package edu.mum.estore.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.estore.exception.PaymentNotValidException;

@ControllerAdvice
public class EstoreExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
	
	
	@ExceptionHandler(PaymentNotValidException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(RuntimeException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
}
