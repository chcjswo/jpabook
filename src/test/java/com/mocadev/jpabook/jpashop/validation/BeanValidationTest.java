package com.mocadev.jpabook.jpashop.validation;

import com.mocadev.jpabook.jpashop.controller.BookForm;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

class BeanValidationTest {

	@Test
	void beanValidationTest() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		BookForm form = new BookForm();
		form.setName(" ");
		form.setPrice(0);
		form.setStockQty(10000);

		Set<ConstraintViolation<BookForm>> violations = validator.validate(form);
		for (ConstraintViolation<BookForm> violation : violations) {
			System.out.println("violation = " + violation);
			System.out.println("violation = " + violation.getMessage());
		}

	}

}
