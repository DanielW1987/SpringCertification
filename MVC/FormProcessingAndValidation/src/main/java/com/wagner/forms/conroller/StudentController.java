package com.wagner.forms.conroller;

import java.util.Map;

import com.wagner.forms.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> otherCountryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("otherCountryOptions", otherCountryOptions);
		return "student/student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "student/student-form";
		}
		else {
			return "student/student-confirmation";
		}	
	}
	
	/**
	 * Pre-process every String form data.
	 * Remove leading and trailing white space.
	 * If String only has white space -> trim it to null.
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true); // true means trim to null
		dataBinder.registerCustomEditor(String.class, trimmer);
	}
	
}