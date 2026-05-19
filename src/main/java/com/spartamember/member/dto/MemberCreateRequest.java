package com.spartamember.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequest {

	private String memberName;
	private int age;
	private String mbti;
}
