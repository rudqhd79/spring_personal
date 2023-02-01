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
}
