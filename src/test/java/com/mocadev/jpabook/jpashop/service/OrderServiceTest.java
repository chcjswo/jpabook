package com.mocadev.jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mocadev.jpabook.jpashop.domain.Address;
import com.mocadev.jpabook.jpashop.domain.Member;
import com.mocadev.jpabook.jpashop.domain.Order;
import com.mocadev.jpabook.jpashop.domain.OrderStatus;
import com.mocadev.jpabook.jpashop.domain.item.Book;
import com.mocadev.jpabook.jpashop.domain.item.Item;
import com.mocadev.jpabook.jpashop.exception.NotEnoughStockException;
import com.mocadev.jpabook.jpashop.respository.OrderRepository;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-24(024)
 **/
@SpringBootTest
@Transactional
class OrderServiceTest {

	@Autowired
	EntityManager em;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Test
	void orderItem() {
		// given
		Member member = getMember();
		Book book = getBook("jpa", 100000, 10);

		int orderCount = 2;
		// when
		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

		// then
		Order getOrder = orderRepository.findOne(orderId);

		assertEquals(OrderStatus.ORDER, getOrder.getStatus());
		assertEquals(1, getOrder.getOrderItems().size());
		assertEquals(100000 * orderCount, getOrder.getTotalPrice());
		assertEquals(8, book.getStockQty());
	}

	private Book getBook(String name, int price, int stockQty) {
		Book book = new Book();
		book.setName(name);
		book.setPrice(price);
		book.setStockQty(stockQty);
		em.persist(book);
		return book;
	}

	private Member getMember() {
		Member member = new Member();
		member.setUsername("member1");
		member.setAddress(new Address("서울", "강남대로", "12345"));
		em.persist(member);
		return member;
	}

	@Test
	void orderCancel() {
		// given
		Member member = getMember();
		Item item = getBook("jpa2", 20000, 10);

		int orderCount = 2;
		// when
		Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

		orderService.cancelOrder(orderId);

		// then
		Order getOrder = orderRepository.findOne(orderId);

		assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
		assertEquals(10, item.getStockQty());
	}

	@Test()
	void itemQuyOverflow() {
		Member member = getMember();
		Item item = getBook("jpa1", 10000, 11);

		int orderCount = 12;

		assertThrows(NotEnoughStockException.class, () ->
			orderService.order(member.getId(), item.getId(), orderCount));

	}

}