package com.dvmendoza.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvmendoza.dojosninjas.models.Ninja;
import com.dvmendoza.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepository;
	
	public void createNinja(Ninja ninja) {
		
		ninjaRepository.save(ninja);
	}
	
	public List<Ninja> getAll() {
		return ninjaRepository.findAll();
	}

	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
		return optionalNinja.get();
		} else {
			return null;
		}
	}

}
