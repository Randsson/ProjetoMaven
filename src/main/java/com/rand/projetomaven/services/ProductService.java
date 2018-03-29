package com.rand.projetomaven.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rand.projetomaven.domain.Product;
import com.rand.projetomaven.repositories.ProductRepository;
import com.rand.projetomaven.services.exceptions.ObjNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public Product search(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
		  "Object not found! Id:" + id + ", Type: "+ Product.class.getName()));			
	}

}
	