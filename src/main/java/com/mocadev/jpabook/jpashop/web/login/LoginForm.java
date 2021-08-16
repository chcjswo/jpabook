package com.mocadev.jpabook.jpashop.web.login;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-17
 **/
@Data
public class LoginForm {

	@NotEmpty
	private String loginId;

	@NotEmpty
	private String password;

}
