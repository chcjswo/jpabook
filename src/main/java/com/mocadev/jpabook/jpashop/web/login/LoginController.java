package com.mocadev.jpabook.jpashop.web.login;

import com.mocadev.jpabook.jpashop.domain.login.LoginService;
import com.mocadev.jpabook.jpashop.domain.member.Member;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-08-17
 **/
@Controller
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@GetMapping("/login")
	public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
		return "login/loginForm";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute LoginForm form,
						BindingResult bindingResult,
						@RequestParam(defaultValue = "/") String redirectUrl) {
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}

		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		if (loginMember == null) {
			bindingResult.reject("loginFail", "아이디 또는 패스워드가 맞지 않습니다.");
			return "login/loginForm";
		}

		return "redirect:" + redirectUrl;
	}

}
