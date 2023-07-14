package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderContorller {
	@GetMapping(value = "/header_util")
	public String header_util() {

		return "/header/header_util";
	}
	@GetMapping(value = "/header_mypage_receipt")
	public String header_mypage_receipt() {
		
		return "/header/header_mypage_receipt";
	}

	@GetMapping(value = "/header_cart_list")
	public String header_cart_list() {

		return "/header/header_cart_list";
	}

	@GetMapping(value = "/header_mypage")
	public String header_mypage() {

		return "/header/header_mypage";
	}

	@GetMapping(value = "/header_reservation")
	public String header_reservation() {

		return "/header/header_reservation";
	}

	@GetMapping(value = "/header_payment")
	public String header_payment() {

		return "/header/header_payment";
	}

	@GetMapping(value = "/header_sitemap")
	public String header_sitemap() {

		return "/header/header_sitemap";
	}

	@GetMapping(value = "/header_sreser")
	public String header_sreser() {

		return "/header/header_sreser";
	}

}
