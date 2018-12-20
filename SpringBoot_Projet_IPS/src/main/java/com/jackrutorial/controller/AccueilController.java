package com.jackrutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class AccueilController {
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String accueilDisplay() {		
		return "home/accueil.html";
	}
	
	@RequestMapping(value ="bootstrap", method = RequestMethod.GET)
	public String booststrapDisplay() {		
		return "bootstrapTest.html";
	}
	
	
	@RequestMapping(value ="index", method = RequestMethod.GET)
	public String indexDisplay() {		
		return "index.html";
	}
	

}
