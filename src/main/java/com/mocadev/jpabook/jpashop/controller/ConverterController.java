package com.mocadev.jpabook.jpashop.controller;

import com.mocadev.jpabook.jpashop.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-01
 **/
@Slf4j
@Controller
public class ConverterController {

	@ResponseBody
	@GetMapping("/converterV2")
	public String converterV2(@RequestParam Integer data) {
		System.out.println("data = " + data);
		return "ok";
	}

	@GetMapping("/converter-view")
	public String converter(Model model) {
		model.addAttribute("number", 10000);
		model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));
		return "converter/converter-view";
	}

}
