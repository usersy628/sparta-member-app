package com.spartamember.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spartamember.member.dto.MemberCreateRequest;
import com.spartamember.member.dto.MemberCreateResponse;
import com.spartamember.member.dto.MemberGetResponse;
import com.spartamember.member.entity.Member;
import com.spartamember.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

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
			savedMember.getMbti()
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
			member.getMbti()
		);
	}
}
