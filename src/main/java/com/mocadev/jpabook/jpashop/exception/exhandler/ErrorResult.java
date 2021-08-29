package com.mocadev.jpabook.jpashop.exception.exhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-29
 **/
@Data
@AllArgsConstructor
public class ErrorResult {

	private String code;
	private String message;
}
