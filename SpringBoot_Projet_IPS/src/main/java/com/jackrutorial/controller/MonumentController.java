package com.jackrutorial.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jackrutorial.DAO.*;

import com.jackrutorial.model.Monument;
import com.jackrutorial.service.Services;

@Controller
@RequestMapping("/home")
public class MonumentController {
	@Autowired
	private MonumentDAO dao;
	private @Valid Monument monument;
	@Autowired
    private Services services;
	
	
	
	
	
	@GetMapping("listMonument")
	public String  listLieu(Model model) {
		model.addAttribute("Monument",services.findAllMon());
		
		return "home/getMon.html";
		
	}
	@RequestMapping(value ="/formulaireMonument", method = RequestMethod.GET)
	public String adddep(Model model) {
		model.addAttribute("MonForm", new Monument());
		return "home/addMon";
	}
	
	@PostMapping(value ="/addfom")
	public String addMon(@Valid @ModelAttribute("Monument") Monument monument){
		dao.save(monument);
	
		monument.getCodeM();
		return "redirect:listMonument";
	}

	/*@RequestMapping(value ="/listMon", method = RequestMethod.GET)
	public String afficherMon(Model model) {
		
		List<Monument> M= dao.findAll();
		model.addAttribute("monument",M);
		return "getMon";
	}
	
	@RequestMapping(value ="/formulaireMonument", method = RequestMethod.GET)
	public String addMonument(Model model) {
		model.addAttribute("monForm", new Monument());
		return "addMon";*/
	}
