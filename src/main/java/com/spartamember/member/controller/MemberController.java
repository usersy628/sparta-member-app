package com.spartamember.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spartamember.member.dto.MemberCreateRequest;
import com.spartamember.member.dto.MemberCreateResponse;
import com.spartamember.member.dto.MemberGetResponse;
import com.spartamember.member.service.MemberService;
import com.spartamember.s3.dto.S3DownloadUrlResponse;
import com.spartamember.s3.dto.S3UploadResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemberGetResponse> getMember(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(memberService.getOne(id));
	}

	@PostMapping("/{id}/profile-image")
	public ResponseEntity<S3UploadResponse> updateProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		String key = memberService.updateProfileImage(id, file);
		return ResponseEntity.ok(new S3UploadResponse(key));
	}

	@GetMapping("/{id}/profile-image")
	public ResponseEntity<S3DownloadUrlResponse> getDownloadUrl(@PathVariable Long id) {
		String url = memberService.getProfileImageDownloadUrl(id);
		return ResponseEntity.ok(new S3DownloadUrlResponse(url));
	}
}
