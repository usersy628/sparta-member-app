package com.spartamember.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spartamember.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
