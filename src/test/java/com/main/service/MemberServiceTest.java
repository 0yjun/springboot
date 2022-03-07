package com.main.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.BootstrapWith;

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
	public void validateDuplicateMember() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2= new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		
		try {
			memberService.join(member2);
			fail("중복 예외발생");
		} catch (IllegalStateException e) {
			// TODO: handle exception
		}
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
