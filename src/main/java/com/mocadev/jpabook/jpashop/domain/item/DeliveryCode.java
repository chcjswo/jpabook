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

	private String code;
	private String displayName;

}
