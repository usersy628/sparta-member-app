package com.spartamember.common.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
		IllegalArgumentException ex,
		HttpServletRequest request
	) {
		log.error("[API - ERROR] 잘못된 요청입니다. uri={}", request.getRequestURI(), ex);

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST.value(),
			HttpStatus.BAD_REQUEST.getReasonPhrase(),
			ex.getMessage(),
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(
		Exception ex,
		HttpServletRequest request
	) {
		log.error("[API - ERROR] 서버 내부 오류가 발생했습니다. uri={}", request.getRequestURI(), ex);

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
			"서버 내부 오류가 발생했습니다.",
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}