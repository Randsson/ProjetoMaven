package com.rand.projetomaven.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rand.projetomaven.domain.Costumer;
import com.rand.projetomaven.repositories.CostumerRepository;
import com.rand.projetomaven.services.exceptions.ObjNotFoundException;

@Service
public class CostumerService {
	
	@Autowired
	private CostumerRepository repo;
	
	public Costumer find(Integer id) {
		Optional<Costumer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
		  "Object not found! Id:" + id + ", Type: "+ Costumer.class.getName()));			
	}

}
	