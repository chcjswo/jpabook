package com.mocadev.jpabook.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-02
 **/
@Data
@AllArgsConstructor
public class DeliveryCode {

	/**
	 * FAST: 빠른 배송
	 * NORMAL: 일반 배송
	 * SLOW: 느린 배송
	 */

	private String code;
	private String displayName;

}
