package com.mocadev.jpabook.jpashop.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-21
 **/
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) throws Exception {
		String requestURI = request.getRequestURI();

		log.info("인증 체크 인터셉터 실행 {}", requestURI);
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("session") == null) {
			log.info("미인증 사용자 요청");
			response.sendRedirect("/login?redirectUrl=" + requestURI);
			return false;
		}

		return true;
	}

}
