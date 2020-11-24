package com.mocadev.jpabook.jpashop.controller;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @since 2020-11-25(025)
 **/
@Getter
@Setter
public class MemberForm {

	@NotEmpty(message = "회원이름은 필수 입니다.")
	private String name;

	private String city;
	private String street;
	private String zipcode;

}
