package com.mocadev.jpabook.jpashop.respository.query;

import com.mocadev.jpabook.jpashop.domain.Address;
import com.mocadev.jpabook.jpashop.domain.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-12-06(006)
 **/
@Data
public class OrderQueryDto {

	private Long orderId;
	private String name;
	private LocalDateTime orderDate;
	private OrderStatus orderStatus;
	private Address address;
	private List<OrderItemQueryDto> orderItem;

	public OrderQueryDto(Long orderId, String name, LocalDateTime orderDate,
						 OrderStatus orderStatus, Address address) {
		this.orderId = orderId;
		this.name = name;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.address = address;
	}
}
