package com.spooky.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spooky.dojos.models.Dojo;
import com.spooky.dojos.models.Ninja;
import com.spooky.dojos.repositories.DojoRepository;
import com.spooky.dojos.repositories.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
}
