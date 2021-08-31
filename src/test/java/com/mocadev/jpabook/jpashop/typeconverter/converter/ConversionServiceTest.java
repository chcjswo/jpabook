package com.mocadev.jpabook.jpashop.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-01
 **/
public class ConversionServiceTest {

	@Test
	void conversionServiceTest() {
		DefaultConversionService defaultConversionService = new DefaultConversionService();
		defaultConversionService.addConverter(new StringToIntegerConverter());
		defaultConversionService.addConverter(new IntegerToStringConverter());
		defaultConversionService.addConverter(new StringToIpPortConverter());

		assertThat(defaultConversionService.convert("10", Integer.class)).isEqualTo(10);
		assertThat(defaultConversionService.convert(10, String.class)).isEqualTo("10");
	}

}
