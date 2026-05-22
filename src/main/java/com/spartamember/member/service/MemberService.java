package com.spartamember.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spartamember.member.dto.MemberCreateRequest;
import com.spartamember.member.dto.MemberCreateResponse;
import com.spartamember.member.dto.MemberGetResponse;
import com.spartamember.member.entity.Member;
import com.spartamember.member.repository.MemberRepository;
import com.spartamember.s3.service.S3Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final S3Service s3Service;

	@Transactional
	public MemberCreateResponse save(MemberCreateRequest request) {

		Member member = new Member(
			request.getMemberName(),
			request.getAge(),
			request.getMbti()
		);
		Member savedMember = memberRepository.save(member);

		return new MemberCreateResponse(
			savedMember.getId(),
			savedMember.getMemberName(),
			savedMember.getAge(),
			savedMember.getMbti(),
			savedMember.getProfileImageKey()
		);
	}

	@Transactional(readOnly = true)
	public MemberGetResponse getOne(Long id) {
		Member member = memberRepository.findById(id).orElseThrow(
			() -> new IllegalStateException("없는 멤버입니다.")
		);

		return new MemberGetResponse(
			member.getId(),
			member.getMemberName(),
			member.getAge(),
			member.getMbti(),
			member.getProfileImageKey()
		);
	}

	@Transactional
	public String updateProfileImage(Long memberId, MultipartFile file) {
		Member member = memberRepository.findById(memberId)
			.orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

		String profileImageKey = s3Service.upload(file);

		member.updateProfileImageKey(profileImageKey);

		return profileImageKey;
	}

	@Transactional(readOnly = true)
	public String getProfileImageDownloadUrl(Long id) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

		String key = member.getProfileImageKey();

		if (key == null || key.isBlank()) {
			throw new IllegalArgumentException("등록된 프로필 이미지가 없습니다.");
		}

		return s3Service.getDownloadUrl(key).toString();
	}
}
