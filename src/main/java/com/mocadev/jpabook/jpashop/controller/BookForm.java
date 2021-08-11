package com.mocadev.jpabook.jpashop.controller;

import com.mocadev.jpabook.jpashop.domain.item.ItemType;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-26(026)
 **/
@Getter
@Setter
public class BookForm {

	private Long id;

	@NotBlank
	private String name;

	@NotNull
	@Range(min = 1000, max = 100000)
	private Integer price;

	@NotNull
	@Max(9999)
	private Integer stockQty;

	private String author;
	private String isbn;
	private boolean open;
	private Map<String, String> regions;
	private ItemType itemType;
	private String deliveryCode;

}
