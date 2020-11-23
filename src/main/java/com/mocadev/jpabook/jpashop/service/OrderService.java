package com.mocadev.jpabook.jpashop.service;

import com.mocadev.jpabook.jpashop.domain.Delivery;
import com.mocadev.jpabook.jpashop.domain.Member;
import com.mocadev.jpabook.jpashop.domain.Order;
import com.mocadev.jpabook.jpashop.domain.OrderItem;
import com.mocadev.jpabook.jpashop.domain.item.Item;
import com.mocadev.jpabook.jpashop.respository.ItemRepository;
import com.mocadev.jpabook.jpashop.respository.MemberRepository;
import com.mocadev.jpabook.jpashop.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-23(023)
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	private final ItemRepository itemRepository;

	@Transactional
	public Long order(Long memberId, Long itemId, int count) {
		// 엔티티 조회
		Member member = memberRepository.findOne(memberId);
		Item item = itemRepository.findOne(itemId);

		// 배송정보 생성
		Delivery delivery = new Delivery();
		delivery.setAddress(member.getAddress());

		// 주문상품 생성
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

		// 주문 생성
		Order order = Order.createOrder(member, delivery, orderItem);

		// 주문 저장
		orderRepository.save(order);
		return order.getId();
	}

	@Transactional
	public void cancelOrder(Long orderId) {
		Order order = orderRepository.findOne(orderId);
		order.cancel();
	}

//	public List<Order> findOrder(OrderSearch orderSearch) {
//		return orderRepository.findAll(orderSearch);
//	}

}
