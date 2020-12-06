package com.mocadev.jpabook.jpashop.respository.query;

import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-12-06(006)
 **/
@Data
public class OrderItemQueryDto {

	private Long orderId;
	private String itemName;
	private int orderPrice;
	private int count;

	public OrderItemQueryDto(Long orderId, String itemName, int orderPrice, int count) {
		this.orderId = orderId;
		this.itemName = itemName;
		this.orderPrice = orderPrice;
		this.count = count;
	}
}
