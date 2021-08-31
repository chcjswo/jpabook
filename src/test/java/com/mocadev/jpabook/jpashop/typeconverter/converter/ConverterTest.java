package com.mocadev.jpabook.jpashop.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.mocadev.jpabook.jpashop.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-31
 **/
class ConverterTest {

	@Test
	void stringToInteger() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		Integer result = converter.convert("10");
		assertThat(result).isEqualTo(10);
	}

	@Test
	void integerToString() {
		IntegerToStringConverter converter = new IntegerToStringConverter();
		String result = converter.convert(10);
		assertThat(result).isEqualTo("10");
	}

	@Test
	void stringToIpPortTest() {
		StringToIpPortConverter converter = new StringToIpPortConverter();
		String source = "127.0.0.1:8080";
		IpPort result = converter.convert(source);
		assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
	}

}
