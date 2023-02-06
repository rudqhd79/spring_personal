package com.busreservation.controller;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.busreservation.dto.CustomerFormDto;
import com.busreservation.entity.Customer;
import com.busreservation.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class ReservationController {
	
	private final CustomerService customerService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "")
	public String main() {
		return "main";
	}
	
	@PostMapping(value = "lookup")
	public String lookup() {
		return "reservation/lookup";
	}
	
	@PostMapping(value = "seat")
	public String seat() {
		return "reservation/seat";
	}
	
	@GetMapping(value = "login")
	public String login() {
		return "login/login";
	}
	
	//사이드 바 경로
	@GetMapping(value = "join")
	public String memberForm(Model model) {
		model.addAttribute("customerFormDto", new CustomerFormDto());
		return "login/join";
	}
	
	//회원가입 버튼을 눌렀을때 실행되는 메소드
		@PostMapping(value = "new")
		public String memberForm(@Valid CustomerFormDto customerFormDto, BindingResult bindingResult, Model model) {
			//@Valid : 유효성을 검증하려는 객체 앞에 붙인다.
			//bindingResult: 유효성 검증후에 결과를 넣어준다.
			
			//에러가 있다면 회원가입 페이지로 이동
			if(bindingResult.hasErrors()) {
				return "login/join";
			}
			
			try {			
				Customer member = Customer.createCustomer(customerFormDto, passwordEncoder);
				customerService.saveMember(member);
			} catch (IllegalStateException e) {
				model.addAttribute("errorMessage", e.getMessage());
				return "member/memberForm";
			}
			
			return "redirect:/";
		}
	
	@GetMapping(value = "check")
	public String check() {
		return "reservation/check";
	}
	
	@GetMapping(value = "cancel")
	public String cancel() {
		return "reservation/cancel";
	}
	
	@GetMapping(value = "edit")
	public String edit() {
		return "edit/edit";
	}
	
	@PostMapping(value = "edit_input")
	public String edit_input() {
		return "edit/edit_input";
	}
}
