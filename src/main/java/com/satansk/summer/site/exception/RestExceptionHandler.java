package com.satansk.summer.site.exception;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.satansk.summer.config.annotation.RestEndpointAdvice;

@RestEndpointAdvice
public class RestExceptionHandler {
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e) {
//		ErrorResponse errors = new ErrorResponse();
//		
//		for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//			ErrorItem error = new ErrorItem();
//			error.setCode(violation.getMessageTemplate());
//			error.setMessage(violation.getMessage());
//			errors.addError(error);
//		}
//		
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
	
	
	public static class ErrorItem {
		private String code;
		private String message;
		
		@XmlElement
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		@XmlElement
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	@XmlRootElement(name = "errors")
	public static class ErrorResponse {
		private List<ErrorItem> errors = new ArrayList<>();

		@XmlElement
		public List<ErrorItem> getErrors() {
			return errors;
		}

		public void setErrors(List<ErrorItem> errors) {
			this.errors = errors;
		}
		
		public void addError(ErrorItem error) {
			this.errors.add(error);
		}
	}
}
