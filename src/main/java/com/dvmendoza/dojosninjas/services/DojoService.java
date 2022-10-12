package com.dvmendoza.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvmendoza.dojosninjas.models.Dojo;

import com.dvmendoza.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepository;

	public void createDojo(Dojo dojo) {
		// TODO Auto-generated method stub
		dojoRepository.save(dojo);
		
	}

	public List<Dojo> getAll() {
		return dojoRepository.findAll();
	}

	public Dojo findDojo(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Dojo> dojo=dojoRepository.findById(id);
		return dojo.orElse(null);
	}


}
