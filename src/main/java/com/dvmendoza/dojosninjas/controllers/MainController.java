package com.dvmendoza.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dvmendoza.dojosninjas.models.Dojo;
import com.dvmendoza.dojosninjas.models.Ninja;
import com.dvmendoza.dojosninjas.services.DojoService;
import com.dvmendoza.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dojo/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos")
		public String newDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojo/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showAll(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showall.jsp";
	}
	
	@GetMapping("all/dojos")
	public String show(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos", dojos);
		return "show.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String newNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
	if(result.hasErrors()) {
		return "ninja.jsp";
	} else {
		ninjaService.createNinja(ninja);
		return "redirect:/ninja/new";
	}
}

}
