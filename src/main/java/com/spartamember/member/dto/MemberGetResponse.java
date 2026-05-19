package com.spartamember.member.dto;

import lombok.Getter;

@Getter
public class MemberGetResponse {

	private final Long id;
	private final String memberName;
	private final int age;
	private final String mbti;

	public MemberGetResponse(Long id, String memberName, int age, String mbti) {
		this.id = id;
		this.memberName = memberName;
		this.age = age;
		this.mbti = mbti;
	}
}
