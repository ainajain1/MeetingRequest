package com.brillio.meeting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MeetingExceptionHandler {

	@ExceptionHandler(value = MeetingException.class)
	public ResponseEntity<String> handleGenericNotFoundException(MeetingException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
