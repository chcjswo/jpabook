package com.mocadev.jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-25(025)
 **/
@Controller
@Slf4j
public class HomeController {

	@RequestMapping("/")
	public String home() {
		log.info("home controller");
		return "home";
	}

}
