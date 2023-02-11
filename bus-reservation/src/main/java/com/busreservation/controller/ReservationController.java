package com.busreservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.busreservation.dto.CustomerFormDto;
import com.busreservation.dto.PathDto;
import com.busreservation.dto.ReservationDto;
import com.busreservation.dto.TerminalDto;
import com.busreservation.entity.Customer;
import com.busreservation.entity.Path;
import com.busreservation.entity.Terminal;
import com.busreservation.repository.PathRepository;
import com.busreservation.repository.TerminalRepository;
import com.busreservation.service.CustomerService;
import com.busreservation.service.PathService;
import com.busreservation.service.BusTerminalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class ReservationController {
	
	private final CustomerService customerService;
	private final PasswordEncoder passwordEncoder;
	private final TerminalRepository terminalRepository;
	private final BusTerminalService busTerminalService;
	private final PathService pathService;
	
	@GetMapping(value = "")
	public String main(Model model) {
		List<TerminalDto> terminals = busTerminalService.getTerminals();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		terminals.stream().forEach(System.out::println);
		model.addAttribute("terminals", terminals);
		return "main";
	}
	
	@GetMapping(value ="reservation")
	public String reservation(@RequestParam ArrayList<String> checkedValue, ReservationDto reservationDto, Model model) {
		System.out.println("checkedValues ---> " + checkedValue);
		
//		model.addAttribute("checked", checkedValue);
		return "main";
	}
	
	@PostMapping(value = "lookup")
	public String lookUp(@RequestParam Long nday1, @RequestParam Long nday2, Model model) {
		System.out.println("---> nday1 : " + nday1);
		System.out.println("---> nday2 : " + nday2);
		
		model.addAttribute("paths", pathService.getPaths(nday1, nday2));
		
		return "reservation/lookup";
	}
	
	@PostMapping(value = "seat")
	public String seat() {
		return "reservation/seat";
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
				customerService.saveCustomer(member);
			} catch (IllegalStateException e) {
				model.addAttribute("errorMessage", e.getMessage());
				return "login/join";
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
	
	@GetMapping(value = "edit_input")
	public String edit_input() {
		return "edit/edit_input";
	}
	
	private final SessionManager sessionManager;
	
	
	@GetMapping(value = "login")
	public String login() {
		return "login/login";
	}
	
	//로그인을 실패했을때
	@GetMapping(value = "login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
		return "login/login";
	}
}
