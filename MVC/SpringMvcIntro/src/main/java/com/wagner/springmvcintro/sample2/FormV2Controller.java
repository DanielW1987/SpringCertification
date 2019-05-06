package com.wagner.springmvcintro.sample2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class FormV2Controller {

	@RequestMapping("/showForm")
	public String showForm() {
		return "v2/helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model) {
		String studentsName = request.getParameter("studentName");
		String newName      = studentsName.toUpperCase();
		String message      = "Yo! " + newName;
		
		model.addAttribute("message", message);
		
		return "v2/helloworld";
	}
}
