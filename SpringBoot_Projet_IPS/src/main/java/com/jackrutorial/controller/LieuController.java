package com.jackrutorial.controller;

import javax.validation.Valid;

import java.io.File;
import java.io.FileInputStream;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.http.MediaType;

import com.jackrutorial.DAO.LieuDAO;
import com.jackrutorial.model.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;
import  com.jackrutorial.service.*;

@Repository
@Controller
@RequestMapping("home")
public class LieuController {
	@Autowired
    private Services services;
	@Autowired
	LieuDAO dao;
	
	
	@Value("${dir.images}")
	private String imageDir;
	
	@GetMapping("listLieu")
	public String  listLieu(Model model) {
		model.addAttribute("lieux",services.findAllLieu());
		return "home/home";
		
	}
	
	
	
    @RequestMapping(value = "/lieux", method = RequestMethod.GET)
	public String showStudentBySurname(@RequestParam (value = "codeInsee", required = false) String codeInsee, Model model) {
	    model.addAttribute("search", services.findByName(codeInsee));
	    return "recherche";
	    }
	
	
	@RequestMapping(value ="/formulaireLieu", method = RequestMethod.GET)
	public String addLieu(Model model) {
		model.addAttribute("lieu", new Lieu());
		return "home/addLieu";
	}
	
	
	
	

	@PostMapping(value ="/addLieu")
	public String addLieu(@Valid @ModelAttribute("lieu") Lieu lieu, BindingResult bindingResult,
			@RequestParam(name="picture") MultipartFile file) throws Exception {
		if (bindingResult.hasErrors()) {
			return "home/addLieu";
		}
		if (!(file.isEmpty())) { lieu.setPhoto(file.getOriginalFilename());}
		dao.save(lieu);

		if (!(file.isEmpty())){
			lieu.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(imageDir+
			lieu.getCodeInsee()));
		}
		return "redirect:listLieu";
		}
	@RequestMapping(value ="supprimer")
	public String  supprimer(String codeInsee ) {
		services.delete(codeInsee);
		return "redirect:listLieu";
	}
	//afficher juste les pages de 5 
	
	
	@RequestMapping(value="/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE )
	@ResponseBody
	public byte[] getPhoto(String codeInsee) throws Exception{
		File f = new File(imageDir+codeInsee);
		return org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(f));
	
	}
	
/*@RequestMapping(value="/saveEdit", method = RequestMethod.PUT)
public ModelAndView  saveEditLieu(@ModelAttribute("lieuEdit") Lieu l) {
		
	Lieu lieu = services.findOne(l.getCodeInsee());
		
	lieu.setCodeInsee(l.getCodeInsee());
	lieu.setNomCom(l.getNomCom());
	lieu.setLongitude(l.getLongitude());
	lieu.setLatitude(l.getLatitude());
	lieu.setPhoto(l.getPhoto());
	
	dao.save(lieu);
	return new ModelAndView("redirect:listLieu");
	}*/


 @RequestMapping(path = "/edit/{codeInsee}", method = RequestMethod.GET)
    public String editLieu(Model model, @PathVariable(value = "codeInsee") String codeInsee) {
        model.addAttribute("lieuEdit", services.findOne(codeInsee));
        return "home/editLieu";
    }
 @PostMapping(value ="/editLieu")
 public ModelAndView editLieu(@ModelAttribute("lieuEdit") Lieu lieu, @RequestParam(name="picture") MultipartFile file) throws Exception {

  
  Lieu l = services.findOne(lieu.getCodeInsee());
  
  l.setCodeInsee(lieu.getCodeInsee());
  l.setNomCom(lieu.getNomCom());
  l.setLongitude(lieu.getLongitude());
  l.setLatitude(lieu.getLatitude());
  
  dao.save(l);


  if (!(file.isEmpty())){
   l.setPhoto(file.getOriginalFilename());
   file.transferTo(new File(imageDir+
   lieu.getCodeInsee()));
  }
  

  
  return new ModelAndView ("redirect:listLieu");
  }



 

	
}

