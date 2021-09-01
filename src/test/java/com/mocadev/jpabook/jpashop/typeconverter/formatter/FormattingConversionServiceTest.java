package com.mocadev.jpabook.jpashop.typeconverter.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import com.mocadev.jpabook.jpashop.typeconverter.converter.IpPortToStringConverter;
import com.mocadev.jpabook.jpashop.typeconverter.converter.StringToIpPortConverter;
import com.mocadev.jpabook.jpashop.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-09-02
 **/
public class FormattingConversionServiceTest {

	@Test
	void test() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

		conversionService.addConverter(new StringToIpPortConverter());
		conversionService.addConverter(new IpPortToStringConverter());
		conversionService.addFormatter(new MyNumberFormatter());

		IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
		assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

		assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
		assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);
	}

}
