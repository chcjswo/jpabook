package com.mocadev.jpabook.jpashop.web.member;

import com.mocadev.jpabook.jpashop.domain.member.Member;
import com.mocadev.jpabook.jpashop.domain.member.MemberRepositoryV2;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberControllerV2 {

	private final MemberRepositoryV2 memberRepository;

	@GetMapping("/add")
	public String addForm(@ModelAttribute("member") Member member) {
		return "members/addMemberForm";
	}

	@PostMapping("/add")
	public String saveForm(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "members/addMemberForm";
		}
		memberRepository.save(member);
		return "redirect:/";
	}

}
