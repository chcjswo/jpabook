package com.mocadev.jpabook.jpashop.exception;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-19
 **/
public class NotEnoughStockException extends RuntimeException {

	public NotEnoughStockException() {
		super();
	}

	public NotEnoughStockException(String message) {
		super(message);
	}

	public NotEnoughStockException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughStockException(Throwable cause) {
		super(cause);
	}
}
