package com.mocadev.jpabook.jpashop.respository;

import com.mocadev.jpabook.jpashop.domain.Order;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-20(020)
 **/
@Repository
@RequiredArgsConstructor
public class OrderRepository {

	private final EntityManager em;

	public void save(Order order) {
		em.persist(order);
	}

	public Order findOne(Long id) {
		return em.find(Order.class, id);
	}

//	public List<Order> findAll(OrderSearch orderSearch) {}
}
