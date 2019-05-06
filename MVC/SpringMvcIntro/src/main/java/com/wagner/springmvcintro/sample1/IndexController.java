package com.wagner.springmvcintro.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

  @GetMapping("/")
  public ModelAndView index(Model m) {
    m.addAttribute("introduction", "Welcome to an simple MVC Demo!");
    m.addAttribute("formV1", "v1/showForm");
    m.addAttribute("formV2", "v2/showForm");
    m.addAttribute("formV3", "v3/showForm");

    return new ModelAndView("index");
  }

}