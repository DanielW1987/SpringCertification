package com.wagner.springmvcintro.sample2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v3")
public class FormV3Controller {

	@RequestMapping("/showForm")
	public String showForm() {
		return "v3/helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@RequestParam("studentName") String studentName, Model model) {
		String newName      = studentName.toUpperCase();
		String message      = "Yo! " + newName;
		
		model.addAttribute("message", message);
		
		return "v3/helloworld";
	}
}
