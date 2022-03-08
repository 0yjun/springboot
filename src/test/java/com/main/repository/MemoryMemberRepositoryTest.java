package com.main.repository;

import  static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.main.domain.Member;

public class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		System.out.println("result : "+(result == member));
		assertThat(member).isEqualTo(result);
	};
	
	@Test
	public void findbyname() {
		Member member1 = new Member();
		member1.setName("jun");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("jun2");
		repository.save(member2);
		
		Member result = repository.findByName("jun").get();
		System.out.println("findbyname result : "+result.getName());
		assertThat(result).isEqualTo(member1);

	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("jun");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("jun");
		repository.save(member2);

		List<Member> result = repository.findAll();
		System.out.println("findAll .size : "+result);
		assertThat(result.size()).isEqualTo(2);
	}
	

}
