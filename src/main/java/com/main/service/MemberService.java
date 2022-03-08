package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.domain.Member;
import com.main.repository.MemberRepository;
import com.main.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService{
	private final MemberRepository memberRepository;
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/*회원가입*/
	public Long join(Member member) {
		//�ߺ�ȸ�� x
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
