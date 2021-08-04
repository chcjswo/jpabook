package com.mocadev.jpabook.jpashop.domain.item;

import lombok.Getter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-02
 **/
@Getter
public enum ItemType {

	BOOK("도서"), FOOD("음식"), ETC("기타");

	private final String description;

	ItemType(String description) {
		this.description = description;
	}
}
