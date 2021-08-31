package com.mocadev.jpabook.jpashop.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-31
 **/
@Slf4j
public class IntegerToStringConverter implements Converter<Integer, String> {

	@Override
	public String convert(Integer source) {
		log.info("converter source={}", source);
		return String.valueOf(source);
	}
}
