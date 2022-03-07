package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.domain.Member;
import com.main.repository.MemberRepository;
import com.main.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*ȸ������*/
	public Long join(Member member) {
		//�ߺ�ȸ�� x
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m->{
			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
		});
	}
	
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findeOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
	
}
