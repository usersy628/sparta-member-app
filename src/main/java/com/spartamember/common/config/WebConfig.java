package com.spartamember.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spartamember.common.logging.ApiLogInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final ApiLogInterceptor apiLogInterceptor;

	public WebConfig(ApiLogInterceptor apiLogInterceptor) {
		this.apiLogInterceptor = apiLogInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiLogInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns(
				"/actuator/**",
				"/favicon.ico",
				"/error"
			);
	}
}