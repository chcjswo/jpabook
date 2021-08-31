package com.mocadev.jpabook.jpashop.typeconverter.converter;

import com.mocadev.jpabook.jpashop.typeconverter.type.IpPort;
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
public class StringToIpPortConverter implements Converter<String, IpPort> {

	@Override
	public IpPort convert(String source) {
		log.info("converter source{}", source);
		String[] split = source.split(":");
		String ip = split[0];
		int port = Integer.parseInt(split[1]);
		return new IpPort(ip, port);
	}

}
