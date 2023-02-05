package com.busreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class ReservationController {
	
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
	
	@GetMapping(value = "join")
	public String join() {
		return "login/join";
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
