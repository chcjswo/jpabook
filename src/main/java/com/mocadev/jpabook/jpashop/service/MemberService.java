package com.mocadev.jpabook.jpashop.service;

import com.mocadev.jpabook.jpashop.domain.Member;
import com.mocadev.jpabook.jpashop.respository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-18
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		List<Member> findMembers = memberRepository.findByName(member.getUsername());
		if (!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}

	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Member findOne(Long memberId) {
		return memberRepository.findOne(memberId);
	}

}
