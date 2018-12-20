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

import com.jackrutorial.DAO.DepartementDAO;
import com.jackrutorial.model.Departement;

import com.jackrutorial.service.Services;



@Controller
@RequestMapping("home") 															
public class DepartementController {
	@Autowired
    private Services services;
	@Autowired
	private DepartementDAO dao;
	private @Valid Departement departement;
	
	


	@GetMapping("listDep")
	public String  listLieu(Model model) {
		model.addAttribute("departements",services.findAlldep());
		
		return "home/getDep.html";
		
	}
	
	@RequestMapping(value ="/formulaireDepartement", method = RequestMethod.GET)
	public String adddep(Model model) {
		model.addAttribute("depForm", new Departement());
		return "home/addDep";
	}
	
	@PostMapping(value ="/addDep")
	public String adddep(@Valid @ModelAttribute("depFormulaire") Departement departement){
		dao.save(departement);
	
		departement.getChefLieu();
		return "redirect:listDep";
	}

	@RequestMapping(value ="/delete")
	public String  supprimer(String dep ) {
		services.deleteDEP(dep);
		return "redirect:listDep";
	}
	
	
}
