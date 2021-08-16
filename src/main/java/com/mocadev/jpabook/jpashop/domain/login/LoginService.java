package com.mocadev.jpabook.jpashop.domain.login;

import com.mocadev.jpabook.jpashop.domain.member.Member;
import com.mocadev.jpabook.jpashop.domain.member.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-17
 **/
@Service
@RequiredArgsConstructor
public class LoginService {

	private final MemberRepositoryV2 memberRepositoryV2;

	public Member login(String loginId, String password) {
		return memberRepositoryV2.findByLoginId(loginId)
			.filter(m -> m.getPassword().equals(password))
			.orElse(null);
	}

}
