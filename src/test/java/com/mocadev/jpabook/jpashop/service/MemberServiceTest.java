package com.mocadev.jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.*;

import com.mocadev.jpabook.jpashop.domain.Member;
import com.mocadev.jpabook.jpashop.respository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-19
 **/
@SpringBootTest
@Transactional
class MemberServiceTest {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void joinTest() {
		Member member = new Member();
		member.setUsername("mc.jeon");

		Long savedId = memberService.join(member);

		assertEquals(member, memberRepository.findOne(savedId));
	}

	@Test
	public void joinExceptionTest() {
		Member member1 = new Member();
		member1.setUsername("jeon");

		Member member2 = new Member();
		member2.setUsername("jeon");

		memberService.join(member1);

		assertThrows(IllegalStateException.class, () ->
			memberService.join(member2));
	}
}