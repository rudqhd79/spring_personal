package com.busreservation.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.busreservation.dto.BusDto;
import com.busreservation.dto.CustomerFormDto;
import com.busreservation.dto.PathDto;
import com.busreservation.dto.ReservationFormDto;
import com.busreservation.dto.SeatDto;
import com.busreservation.dto.TerminalDto;
import com.busreservation.entity.BusSeat;
import com.busreservation.entity.Customer;
import com.busreservation.service.CustomerService;
import com.busreservation.service.PathService;
import com.busreservation.service.SeatService;
import com.busreservation.service.BusService;
import com.busreservation.service.BusTerminalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class ReservationController {
	
	private final CustomerService customerService;
	private final PasswordEncoder passwordEncoder;
	private final BusTerminalService busTerminalService;
	private final PathService pathService;
	private final SeatService seatService;
	private final BusService busService;
	
	@GetMapping(value = "")
	public String main(Model model) {
		List<TerminalDto> terminals = busTerminalService.getTerminals();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		terminals.stream().forEach(System.out::println);
		model.addAttribute("terminals", terminals);
		return "main";
	}
	
	@PostMapping(value ="reservation")
	public @ResponseBody ResponseEntity reservation(@RequestBody ReservationFormDto reservationFormDto, Principal principal) {
		System.out.println(reservationFormDto);
		return new ResponseEntity<ReservationFormDto>(reservationFormDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "lookup")
	public String lookUp(@RequestParam Long nday1, @RequestParam Long nday2, Model model) {
//		BusDto busDto = busService.getBusInfo(bus_id);
		List<PathDto> terminals = pathService.getPaths(nday1, nday2);
		terminals.stream().forEach(System.out::println);
//		model.addAttribute("buses", busDto);
		model.addAttribute("paths", terminals);
		
		return "reservation/lookup";
	}
	
	@GetMapping(value = "seat/{pathId}")
	public String seat(Model model, @PathVariable("pathId") Long pathId) {
		PathDto pathDto = pathService.findPathId(pathId);
		List<SeatDto> seats = seatService.getSeats();
//		seats.stream().forEach(System.out::println);
		model.addAttribute("path", pathDto);
		model.addAttribute("seats", seats);
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
