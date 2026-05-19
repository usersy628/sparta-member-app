package com.spartamember.common.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiLogInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(ApiLogInterceptor.class);

	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler
	) {
		String method = request.getMethod();
		String requestUri = request.getRequestURI();

		log.info("[API - LOG] {} {}", method, requestUri);

		return true;
	}
}