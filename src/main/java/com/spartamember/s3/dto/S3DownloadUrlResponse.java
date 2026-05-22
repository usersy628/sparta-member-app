package com.spartamember.s3.dto;

import lombok.Getter;

@Getter
public class S3DownloadUrlResponse {

	private final String url;

	public S3DownloadUrlResponse(String url) {
		this.url = url;
	}
}