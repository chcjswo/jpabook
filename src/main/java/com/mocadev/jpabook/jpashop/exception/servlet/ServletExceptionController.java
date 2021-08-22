package com.mocadev.jpabook.jpashop.exception.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-22
 **/
@Slf4j
@Controller
public class ServletExceptionController {

	@GetMapping("/error-ex")
	public void errorEx() {
		throw new RuntimeException("예외s 발생");
	}

	@GetMapping("/error-404")
	public void error404(HttpServletResponse response) throws IOException {
		response.sendError(404, "404 Page Not Found");
	}

	@GetMapping("/error-500")
	public void error500(HttpServletResponse response) throws IOException {
		response.sendError(500, "500 Server Error");
	}

}
