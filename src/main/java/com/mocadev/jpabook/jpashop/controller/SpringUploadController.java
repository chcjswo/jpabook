
package com.mocadev.jpabook.jpashop.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-03
 **/
@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUploadController {

	@Value("${file.dir}")
	private String fileDir;

	@GetMapping
	public String index() {
		return "file/upload-index";
	}

	@GetMapping("/upload")
	public String newFile() {
		return "file/upload-form";
	}

	@PostMapping("/upload")
	public String saveFileV1(@RequestParam String itemName,
							 @RequestParam MultipartFile file,
							 HttpServletRequest request) throws IOException {
		log.info("request={}", request);
		log.info("itemName={}", itemName);
		log.info("multipartFile={}", file);

		if (!file.isEmpty()) {
			String fullPath = fileDir + file.getOriginalFilename();
			log.info("파일 저장 fullPath={}", fullPath);
			file.transferTo(new File(fullPath));
		}

		return"file/upload-form";

}


}
