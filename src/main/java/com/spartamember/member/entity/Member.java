package com.spartamember.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "members")
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String memberName;
	private int age;
	private String mbti;

	public Member(String memberName, int age, String mbti) {
		this.memberName = memberName;
		this.age = age;
		this.mbti = mbti;
	}
}