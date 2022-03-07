package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.domain.Member;
import com.main.repository.MemberRepository;
import com.main.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*회원가입*/
	public Long join(Member member) {
		//중복회원 x
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findeOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
	
}
