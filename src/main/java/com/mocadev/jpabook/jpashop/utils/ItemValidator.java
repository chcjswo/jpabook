package com.mocadev.jpabook.jpashop.utils;

import com.mocadev.jpabook.jpashop.controller.BookForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BookForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookForm book = (BookForm) target;

		if (!StringUtils.hasText(book.getName())) {
			errors.reject("form", "상품이름은 필수입니다.");
		}
	}

}
