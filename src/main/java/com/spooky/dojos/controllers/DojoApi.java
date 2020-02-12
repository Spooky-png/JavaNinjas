package com.spooky.dojos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spooky.dojos.models.Dojo;
import com.spooky.dojos.models.Ninja;
import com.spooky.dojos.services.DojoService;

@RestController
public class DojoApi {
	private final DojoService dojoService;
	public DojoApi(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	@RequestMapping("/api/dojos")
	public List<Dojo> index(){
		return dojoService.allDojos();
	}
	@RequestMapping("/api/ninjas")
	public List<Ninja> index2(){
		return dojoService.allNinjas();
	}
	@PostMapping(value="/api/dojos")
	public Dojo create(@RequestParam(value="name") String name) {
		Dojo dojo = new Dojo(name);
		return dojoService.createDojo(dojo);
	}
	@PostMapping(value="/api/ninjas")
	public Ninja create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="age") int age, @RequestParam(value="dojo") Dojo dojo) {
		Ninja ninja = new Ninja(firstName, lastName, age, dojo);
		return dojoService.createNinja(ninja);
	}
}
