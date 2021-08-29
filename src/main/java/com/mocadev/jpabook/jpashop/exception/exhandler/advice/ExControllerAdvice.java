package com.mocadev.jpabook.jpashop.exception.exhandler.advice;

import com.mocadev.jpabook.jpashop.exception.exception.UserException;
import com.mocadev.jpabook.jpashop.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-29
 **/
@Slf4j
@RestControllerAdvice({"com.mocadev.jpabook.jpashop.exception.api",
	"com.mocadev.jpabook.jpashop.exception.servlet"})
public class ExControllerAdvice {

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

}
