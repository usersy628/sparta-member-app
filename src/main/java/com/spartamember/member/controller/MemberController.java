package com.spartamember.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spartamember.member.dto.MemberCreateRequest;
import com.spartamember.member.dto.MemberCreateResponse;
import com.spartamember.member.dto.MemberGetResponse;
import com.spartamember.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/api/members")
	public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
	}

	@GetMapping("/api/members/{id}")
	public ResponseEntity<MemberGetResponse> getMember(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(memberService.getOne(id));
	}
}
