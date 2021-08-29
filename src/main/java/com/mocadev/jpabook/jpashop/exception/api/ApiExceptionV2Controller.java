package com.mocadev.jpabook.jpashop.exception.api;

import com.mocadev.jpabook.jpashop.exception.exception.UserException;
import com.mocadev.jpabook.jpashop.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-29
 **/
@Slf4j
@RestController
public class ApiExceptionV2Controller {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorResult illegalArgumentException(IllegalArgumentException e) {
		log.error("error result = ", e);
		return new ErrorResult("BAD", e.getMessage());
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResult> userExHandler(UserException e) {
		ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
		return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ErrorResult exHandler(Exception e) {
		return new ErrorResult("EX", e.getMessage());
	}

	@GetMapping("/api/v2/members/{id}")
	public MemberDto getMember(@PathVariable String id) {
		if (id.equals("ex")) {
			throw new RuntimeException("잘못된 사용자");
		}
		if (id.equals("bad")) {
			throw new IllegalArgumentException("잘못된 입력 값");
		}
		if (id.equals("user-ex")) {
			throw new UserException("사용자 오류");
		}
		return new MemberDto(id, "hello " + id);
	}

	@Data
	@AllArgsConstructor
	static class MemberDto {

		private String memberId;
		private String name;
	}

}
