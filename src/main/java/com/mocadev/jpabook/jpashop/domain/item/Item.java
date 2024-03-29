package com.mocadev.jpabook.jpashop.domain.item;

import com.mocadev.jpabook.jpashop.domain.Category;
import com.mocadev.jpabook.jpashop.exception.NotEnoughStockException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String name;
	private int price;
	private int stockQty;

	private Boolean open;	// 판매 여부
//	private List<String> regions = new ArrayList<>(); // 등록 지역
	@Enumerated(EnumType.STRING)
	private ItemType itemType;	// 상품 종류
	private String deliveryCode;	// 배송 방식

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

	public void addStock(int stockQty) {
		this.stockQty += stockQty;
	}

	public void removeStock(int stockQty) {
		int restStock = this.stockQty - stockQty;
		if (restStock < 0) {
			throw new NotEnoughStockException("need more stock");
		}
		this.stockQty = restStock;
	}

}
