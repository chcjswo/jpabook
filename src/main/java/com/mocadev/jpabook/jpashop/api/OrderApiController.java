package com.mocadev.jpabook.jpashop.api;

import static java.util.stream.Collectors.toList;

import com.mocadev.jpabook.jpashop.domain.Address;
import com.mocadev.jpabook.jpashop.domain.Order;
import com.mocadev.jpabook.jpashop.domain.OrderItem;
import com.mocadev.jpabook.jpashop.domain.OrderSearch;
import com.mocadev.jpabook.jpashop.domain.OrderStatus;
import com.mocadev.jpabook.jpashop.respository.OrderRepository;
import com.mocadev.jpabook.jpashop.respository.query.OrderFlatDto;
import com.mocadev.jpabook.jpashop.respository.query.OrderQueryDto;
import com.mocadev.jpabook.jpashop.respository.query.OrderQueryRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-12-03(003)
 **/
@RestController
@RequiredArgsConstructor
public class OrderApiController {

	private final OrderRepository orderRepository;
	private final OrderQueryRepository orderQueryRepository;

	@GetMapping("/api/v1/orders")
	public List<Order> ordersV1() {
		List<Order> all = orderRepository.findAll(new OrderSearch());
		for (Order order : all) {
			order.getMember().getName();
			order.getDelivery().getAddress();
			List<OrderItem> orderItems = order.getOrderItems();
			orderItems.forEach(o -> o.getItem().getName());
		}
		return all;
	}

	@GetMapping("/api/v2/orders")
	public List<OrderDto> ordersV2() {
		List<Order> orders = orderRepository.findAll(new OrderSearch());

		return orders.stream()
			.map(OrderDto::new)
			.collect(toList());
	}

	@GetMapping("/api/v3.1/orders")
	public List<OrderDto> ordersV3_page(
		@RequestParam(value = "offset", defaultValue = "0") int offset,
		@RequestParam(value = "limit", defaultValue = "100") int limit
	) {
		List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);

		return orders.stream()
			.map(OrderDto::new)
			.collect(toList());
	}

	@GetMapping("/api/v3/orders")
	public List<OrderDto> ordersV3() {
		List<Order> orders = orderRepository.findAllWithItem();

		return orders.stream()
			.map(OrderDto::new)
			.collect(toList());
	}

	@GetMapping("/api/v4/orders")
	public List<OrderQueryDto> ordersV4() {
		List<OrderQueryDto> orderQueryDtos = orderQueryRepository.findOrderQueryDtos();
		return orderQueryDtos;
	}

	@GetMapping("/api/v5/orders")
	public List<OrderQueryDto> ordersV5() {
		List<OrderQueryDto> orderQueryDtos = orderQueryRepository.findAllByDto_optimization();
		return orderQueryDtos;
	}

	@GetMapping("/api/v6/orders")
	public List<OrderFlatDto> ordersV6() {
		List<OrderFlatDto> orderQueryDtos = orderQueryRepository.findAllByDto_flat();
		return orderQueryDtos;
	}

	@Getter
	static class OrderDto {

		private Long orderId;
		private String name;
		private LocalDateTime orderDate;
		private OrderStatus orderStatus;
		private Address address;
		private List<OrderItemDto> orderItems;

		public OrderDto(Order order) {
			orderId = order.getId();
			name = order.getMember().getName();
			orderDate = order.getOrderDate();
			orderStatus = order.getStatus();
			address = order.getDelivery().getAddress();
			orderItems = order.getOrderItems().stream()
				.map(OrderItemDto::new)
				.collect(toList());
		}
	}

	@Getter
	static class OrderItemDto {

		private String itemName;
		private int orderPrice;
		private int count;

		public OrderItemDto(OrderItem orderItem) {
			itemName = orderItem.getItem().getName();
			orderPrice = orderItem.getOrderPrice();
			count = orderItem.getCount();
		}
	}

}
