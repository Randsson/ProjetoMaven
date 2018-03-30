package com.rand.projetomaven.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rand.projetomaven.domain.Category;
import com.rand.projetomaven.repositories.CategoryRepository;
import com.rand.projetomaven.services.exceptions.ObjNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category search(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
		  "Object not found! Id:" + id + ", Type: "+ Category.class.getName()));			
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
	