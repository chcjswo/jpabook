package com.mocadev.jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-01
 **/
@Slf4j
@RestController
public class ConverterController {

	@GetMapping("/converterV2")
	public String converterV2(@RequestParam Integer data) {
		System.out.println("data = " + data);
		return "ok";
	}

}
