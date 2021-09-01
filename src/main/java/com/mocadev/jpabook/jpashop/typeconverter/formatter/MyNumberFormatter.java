package com.mocadev.jpabook.jpashop.typeconverter.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-02
 **/
@Slf4j
public class MyNumberFormatter implements Formatter<Number> {

	@Override
	public Number parse(String text, Locale locale) throws ParseException {
		log.info("text={}, locale={}", text, locale);
		return NumberFormat.getInstance(locale).parse(text);
	}

	@Override
	public String print(Number object, Locale locale) {
		log.info("object={}, locale={}", object, locale);
		return NumberFormat.getInstance(locale).format(object);
	}

}
