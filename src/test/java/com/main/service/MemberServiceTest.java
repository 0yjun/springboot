package com.main.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.main.domain.Member;

class MemberServiceTest {
	MemberService memberService = new MemberService();

	@Test
	void testJoin() {
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberService.join(member);
		//then
		Member findMember = memberService.findeOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	void testFindMembers() {
		fail("Not yet implemented");
	}

	@Test
	void testFindeOne() {
		fail("Not yet implemented");
	}

}
