package com.mocadev.jpabook.jpashop.respository;

import com.mocadev.jpabook.jpashop.domain.Order;
import com.mocadev.jpabook.jpashop.domain.OrderSearch;
import java.util.List;
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

	public List<Order> findAll(OrderSearch orderSearch) {
		return em
			.createQuery("select o  from Order o join o.member m", Order.class)
			.setMaxResults(1000)
			.getResultList();
	}
}
