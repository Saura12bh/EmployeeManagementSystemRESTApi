package org.springMvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmpNotFound.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleEmpNotFound(EmpNotFound ex)
	{
		ErrorResponse er=new ErrorResponse(404,ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
}
