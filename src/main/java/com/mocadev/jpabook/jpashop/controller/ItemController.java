package com.mocadev.jpabook.jpashop.controller;

import com.mocadev.jpabook.jpashop.domain.item.Book;
import com.mocadev.jpabook.jpashop.domain.item.DeliveryCode;
import com.mocadev.jpabook.jpashop.domain.item.Item;
import com.mocadev.jpabook.jpashop.domain.item.ItemType;
import com.mocadev.jpabook.jpashop.service.ItemService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-26(026)
 **/
@Controller
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;

	@ModelAttribute("regions")
	public Map<String, String> regions() {
		Map<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("SUWON", "수원");
		return regions;
	}

	@ModelAttribute("deliveryCodes")
	public List<DeliveryCode> deliveryCodes() {
		List<DeliveryCode> deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
		deliveryCodes.add(new DeliveryCode("NORMAL", "보통 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
		return deliveryCodes;
	}

	@ModelAttribute("itemTypes")
	public ItemType[] itemTypes() {
		return ItemType.values();
	}

	@GetMapping("/items/new")
	public String createForm(Model model) {
		model.addAttribute("form", new BookForm());
		return "items/createItemForm";
	}

	@PostMapping("/items/new")
	public String create(BookForm form) {
		Book book = new Book();
		book.setName(form.getName());
		book.setPrice(form.getPrice());
		book.setStockQty(form.getStockQty());
		book.setAuthor(form.getAuthor());
		book.setIsbn(form.getIsbn());
		book.setOpen(form.isOpen());
		book.setDeliveryCode(form.getDeliveryCode());

		itemService.saveItem(book);
		return "redirect:/";
	}

	@GetMapping("/items")
	public String list(Model model) {
		List<Item> items = itemService.findItems();
		model.addAttribute("items", items);
		return "items/itemList";
	}

	@GetMapping("/items/{itemId}/edit")
	public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
		Book item = (Book) itemService.findOne(itemId);

		BookForm form = new BookForm();
		form.setId(item.getId());
		form.setName(item.getName());
		form.setPrice(item.getPrice());
		form.setStockQty(item.getStockQty());
		form.setAuthor(item.getAuthor());
		form.setIsbn(item.getIsbn());
//		form.setOpen(item.getOpen());
		form.setDeliveryCode(item.getDeliveryCode());

		model.addAttribute("form", form);
		return "items/updateItemForm";
	}

	@PostMapping("/items/{itemId}/edit")
	public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {
		Book book = new Book();
		book.setId(form.getId());
		book.setName(form.getName());
		book.setPrice(form.getPrice());
		book.setStockQty(form.getStockQty());
		book.setAuthor(form.getAuthor());
		book.setIsbn(form.getIsbn());
		book.setOpen(form.isOpen());
		book.setDeliveryCode(form.getDeliveryCode());

		itemService.saveItem(book);
		return "redirect:/items";
	}
}
