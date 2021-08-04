package com.mocadev.jpabook.jpashop.controller;

import com.mocadev.jpabook.jpashop.domain.item.ItemType;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-26(026)
 **/
@Getter
@Setter
public class BookForm {

	private Long id;
	private String name;
	private int price;
	private int stockQty;
	private String author;
	private String isbn;
	private boolean open;
	private Map<String, String> regions;
	private ItemType itemType;

}
