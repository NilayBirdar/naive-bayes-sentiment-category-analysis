package com.naive.bayes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.naive.bayes.app.entities.homePage;

@Controller
public class StajController {
	 
	 @GetMapping(value= {"/","/home"})
	 public String getHomePage(Model model) {
		 model.addAttribute("homePage", new homePage());
	    return "homePage";
	}
	 


	
}
