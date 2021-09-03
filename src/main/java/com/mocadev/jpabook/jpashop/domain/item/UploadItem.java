package com.mocadev.jpabook.jpashop.domain.item;

import java.util.List;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-03
 **/
@Data
public class UploadItem {

	private Long id;
	private String itemName;
	private UploadFile attachFile;
	private List<UploadFile> imageFiles;

}
