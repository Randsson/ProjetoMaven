package com.rand.projetomaven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rand.projetomaven.domain.Costumer;
import com.rand.projetomaven.dto.CostumerDTO;
import com.rand.projetomaven.repositories.CostumerRepository;
import com.rand.projetomaven.services.exceptions.DataIntegrityException;
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
	
	public Costumer update (Costumer obj) {
		Costumer newObj = find(obj.getId());
		updatedData(newObj, obj); //método privado para atualizar somente os dados necessários;
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public List<Costumer> findAll() {
		return repo.findAll();
	}
	
	public Page<Costumer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Costumer fromDTO (CostumerDTO objDTO) {
		return new Costumer(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null);
	}

	
	private void updatedData (Costumer newObj, Costumer obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
	