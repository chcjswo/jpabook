package com.mocadev.jpabook.jpashop.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mocadev.jpabook.jpashop.exception.exception.UserException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-27
 **/
@Slf4j
public class UserHandlerExceptionResolver implements HandlerExceptionResolver {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public ModelAndView resolveException(
		HttpServletRequest request, HttpServletResponse response,
		Object handler, Exception ex) {
		try {
			if (ex instanceof UserException) {
				log.info("UserException resolver to 400");
				String accept = request.getHeader("accept");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);

				if ("application.json".equals(accept)) {

				}
			}

		} catch (IOException e) {
			log.error("user handler exception ", e);
		}
		return null;
	}

}
