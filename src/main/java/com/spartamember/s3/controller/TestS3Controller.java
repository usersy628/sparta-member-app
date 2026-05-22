package com.spartamember.s3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import com.spartamember.s3.service.S3Service;

@RestController
@RequestMapping("/api/files")
public class TestS3Controller {

	private final S3Service s3Service;

	public TestS3Controller(S3Service s3Service) {
		this.s3Service = s3Service;
	}

	@PostMapping("/profile-image")
	public ResponseEntity<Map<String, String>> uploadProfileImage(
		@RequestParam("file") MultipartFile file
	) {
		String key = s3Service.upload(file);

		return ResponseEntity.ok(Map.of(
			"message", "프로필 이미지 업로드 성공",
			"key", key
		));
	}
}