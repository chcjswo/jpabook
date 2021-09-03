package com.mocadev.jpabook.jpashop.controller;

import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-04
 **/
@Data
public class UploadItemForm {

	private Long itemId;
	private String itemName;
	private List<MultipartFile> imageFiles;
	private MultipartFile attachFile;

}
