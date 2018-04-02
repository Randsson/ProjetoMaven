package com.rand.projetomaven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rand.projetomaven.domain.Category;
import com.rand.projetomaven.dto.CategoryDTO;
import com.rand.projetomaven.repositories.CategoryRepository;
import com.rand.projetomaven.services.exceptions.DataIntegrityException;
import com.rand.projetomaven.services.exceptions.ObjNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find (Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
		  "Object not found! Id:" + id + ", Type: "+ Category.class.getName()));			
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	public Category update (Category obj) {
		Category newObj = find(obj.getId());
		updatedData(newObj, obj); //método privado para atualizar somente os dados necessários;
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Category> findAll() {
		return repo.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Category fromDTO (CategoryDTO objDTO) {
		return new Category(objDTO.getId(), objDTO.getName());
	}
	
	
	
	private void updatedData (Category newObj, Category obj) {
		newObj.setName(obj.getName());
	}
}
	