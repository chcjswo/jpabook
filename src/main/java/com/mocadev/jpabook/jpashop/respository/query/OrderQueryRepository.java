package com.mocadev.jpabook.jpashop.respository.query;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-12-06(006)
 **/
@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

	private final EntityManager em;

	public List<OrderQueryDto> findOrderQueryDtos() {
		List<OrderQueryDto> result = findOrders();
		
		result.forEach(o -> {
			List<OrderItemQueryDto> orderItems = findOrderItems(o.getOrderId());
			o.setOrderItem(orderItems);
		});
		return result;
	}

	private List<OrderItemQueryDto> findOrderItems(Long orderId) {
		return em.createQuery(
			"select new com.mocadev.jpabook.jpashop.respository.query.OrderItemQueryDto(oi.order.Id, i.name, oi.orderPrice, oi.count) "
				+ "from OrderItem oi "
				+ "join oi.item i "
				+ "where oi.order.Id = :orderId ", OrderItemQueryDto.class)
			.setParameter("orderId", orderId)
			.getResultList();
	}

	public List<OrderQueryDto> findOrders() {
		return em.createQuery(
			"select new com.mocadev.jpabook.jpashop.respository.query.OrderQueryDto(o.Id, m.name, o.orderDate, o.status, d.address) "
				+ "from Order o "
				+ "join o.member m "
				+ "join o.delivery d", OrderQueryDto.class)
			.getResultList();
	}

	public List<OrderQueryDto> findAllByDto_optimization() {
		List<OrderQueryDto> result = findOrders();
		List<Long> orderIds = result.stream()
			.map(OrderQueryDto::getOrderId)
			.collect(Collectors.toList());

		List<OrderItemQueryDto> orderItems = em.createQuery(
			"select new com.mocadev.jpabook.jpashop.respository.query.OrderItemQueryDto(oi.order.Id, i.name, oi.orderPrice, oi.count) "
				+ "from OrderItem oi "
				+ "join oi.item i "
				+ "where oi.order.Id in :orderIds ", OrderItemQueryDto.class)
			.setParameter("orderIds", orderIds)
			.getResultList();

		Map<Long, List<OrderItemQueryDto>> orderItemMap = orderItems.stream()
			.collect(Collectors.groupingBy(OrderItemQueryDto::getOrderId));

		result.forEach(o -> o.setOrderItem(orderItemMap.get(o.getOrderId())));

		return  result;
	}

	public List<OrderFlatDto> findAllByDto_flat() {
		return em.createQuery(
			"select new com.mocadev.jpabook.jpashop.respository.query.OrderFlatDto(o.Id, m.name, o.orderDate, o.status, d.address, i.name, oi.orderPrice, oi.orderPrice) "
				+ "from Order o "
				+ "join o.member m "
				+ "join o.delivery d "
				+ "join o.orderItems oi "
				+ "join oi.item i ", OrderFlatDto.class)
		.getResultList();
	}
}
