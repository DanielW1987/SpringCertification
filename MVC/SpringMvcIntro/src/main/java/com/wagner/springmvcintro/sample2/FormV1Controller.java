package com.wagner.springmvcintro.sample2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class FormV1Controller {

	@RequestMapping("/showForm")
	public String showForm() {
		return "v1/helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "v1/helloworld";
	}
	
}