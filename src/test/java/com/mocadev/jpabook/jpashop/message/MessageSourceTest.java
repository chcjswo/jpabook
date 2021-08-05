package com.mocadev.jpabook.jpashop.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-06
 **/
@SpringBootTest
public class MessageSourceTest {

	@Autowired
	MessageSource messageSource;

	@Test
	void helloTest() {
		String result = messageSource.getMessage("hello", null, null);
		assertThat(result).isEqualTo("안녕");
	}

	@Test
	void notFoundMessageCodeTest() {
		assertThatThrownBy(() -> messageSource.getMessage("no_doe", null, null))
			.isInstanceOf(NoSuchMessageException.class);
	}

	@Test
	void defaultMessageCodeTest() {
		String result = messageSource.getMessage("no_doe", null, "default message", null);
		assertThat(result).isEqualTo("default message");
	}

	@Test
	void argsMessageCodeTest() {
		String result = messageSource.getMessage("hello.name", new Object[]{"spring"}, null);
		assertThat(result).isEqualTo("안녕 spring");
	}

	@Test
	void defaultLangTest() {
		String result = messageSource.getMessage("hello", null, Locale.KOREA);
		assertThat(result).isEqualTo("안녕");
	}

	@Test
	void enLangTest() {
		String result = messageSource.getMessage("hello", null, Locale.ENGLISH);
		assertThat(result).isEqualTo("hello");
	}

}
