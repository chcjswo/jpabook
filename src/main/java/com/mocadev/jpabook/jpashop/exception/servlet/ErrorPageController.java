package com.mocadev.jpabook.jpashop.exception.servlet;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-22
 **/
@Slf4j
@Controller
public class ErrorPageController {

	@RequestMapping("/error-page/404")
	public String errorPage404(HttpServletRequest request, HttpServletResponse response) {
		return "error-page/404";
	}

	@RequestMapping("/error-page/500")
	public String errorPage500(HttpServletRequest request, HttpServletResponse response) {
		return "error-page/500";
	}

	@RequestMapping(value = "/error-page/500", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> errorPage500Json(HttpServletRequest request, HttpServletResponse response) {
		log.info("API error 500");
		Map<Object, Object> map = new HashMap<>();
		Exception error = (Exception) request.getAttribute("javax.servlet.error.exception");
		map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		map.put("message", error.getMessage());
		Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		return new ResponseEntity(map, HttpStatus.valueOf(statusCode));
	}

}
