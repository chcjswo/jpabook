package com.mocadev.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-24(024)
 **/
@Getter
@Setter
public class OrderSearch {

	private String memberName;
	private OrderStatus orderStatus;

}
