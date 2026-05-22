package com.spartamember.s3.dto;

import lombok.Getter;

@Getter
public class S3UploadResponse {

	private final String key;

	public S3UploadResponse(String key) {
		this.key = key;
	}
}