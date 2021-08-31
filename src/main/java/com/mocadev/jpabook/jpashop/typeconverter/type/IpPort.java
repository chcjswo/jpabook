package com.mocadev.jpabook.jpashop.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-31
 **/
@Getter
@EqualsAndHashCode
public class IpPort {

	private String ip;
	private int port;

	public IpPort(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
}
