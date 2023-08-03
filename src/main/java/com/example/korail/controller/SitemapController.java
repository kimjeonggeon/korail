package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SitemapController {

	@GetMapping(value = "/sitemap")
	public String sitemap() {

		return "/sitemap/sitemap";
	}

	@GetMapping(value = "BusStpl")
	public String BusStpl() {
		return "/foot_content/BusStpl";
	}

	@GetMapping(value = "IndlStpl")
	public String IndlStpl() {
		return "/foot_content/IndlStpl";
	}

	@GetMapping(value = "svcStpl")
	public String svcStpl() {
		return "/foot_content/svcStpl";
	}

}
