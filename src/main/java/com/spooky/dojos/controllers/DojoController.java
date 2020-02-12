package com.spooky.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spooky.dojos.models.Dojo;
import com.spooky.dojos.models.Ninja;
import com.spooky.dojos.repositories.DojoRepository;
import com.spooky.dojos.repositories.NinjaRepository;
import com.spooky.dojos.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojoController(DojoService dojoService, NinjaRepository ninjaRepository, DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
		this.dojoService = dojoService;
		this.ninjaRepository = ninjaRepository;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojos") Dojo d, Model model) {
		List<Dojo>allDojos = dojoService.allDojos();
		model.addAttribute("dojo", allDojos);
		return "/dojos/newDojo.jsp";
	}
	@PostMapping(value="/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojos") Dojo d, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo>allDojos = dojoService.allDojos();
			model.addAttribute("dojo", allDojos);
			return "/dojos/newDojo.jsp";
		} else {
			dojoService.createDojo(d);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjas") Ninja n, Model model) {
		List<Dojo>allDojos = dojoService.allDojos();
		model.addAttribute("dojo", allDojos);
		return "/dojos/newNinja.jsp";
	}
	@PostMapping(value="/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninjas") Ninja n, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo>allDojos = dojoService.allDojos();
			model.addAttribute("dojo", allDojos);
			return "/dojos/newNinja.jsp";
		} else {
			dojoService.createNinja(n);
			return "redirect:/view";
		}
	}
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/view.jsp";
	}
	public DojoRepository getDojoRepository() {
		return dojoRepository;
	}
	public NinjaRepository getNinjaRepository() {
		return ninjaRepository;
	}

}
