package com.mocadev.jpabook.jpashop.domain.item;

import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-03
 **/
@Data
public class UploadFile {

	private String uploadFileName;
	private String storeFileName;

	public UploadFile(String uploadFileName, String storeFileName) {
		this.uploadFileName = uploadFileName;
		this.storeFileName = storeFileName;
	}

}
