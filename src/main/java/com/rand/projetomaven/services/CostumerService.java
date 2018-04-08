package com.rand.projetomaven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rand.projetomaven.domain.Address;
import com.rand.projetomaven.domain.City;
import com.rand.projetomaven.domain.Costumer;
import com.rand.projetomaven.domain.enums.CostumerKind;
import com.rand.projetomaven.dto.CostumerDTO;
import com.rand.projetomaven.dto.CostumerNewDTO;
import com.rand.projetomaven.repositories.AddressRepository;
import com.rand.projetomaven.repositories.CityRepository;
import com.rand.projetomaven.repositories.CostumerRepository;
import com.rand.projetomaven.services.exceptions.DataIntegrityException;
import com.rand.projetomaven.services.exceptions.ObjNotFoundException;

@Service
public class CostumerService {
	
	@Autowired
	private CostumerRepository repo;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional
	public Costumer insert(Costumer obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addressRepository.saveAll(obj.getAddresses());
		return obj;
	}
	
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

	
	public Costumer fromDTO (CostumerNewDTO objDTO) {
		Costumer costumer = new Costumer( null, objDTO.getName(), objDTO.getEmail(), objDTO.getCpfOuCnpj(), CostumerKind.toEnum(objDTO.getKind()));
		City city = new City(objDTO.getCityId(), null, null);
		cityRepository.save(city);
		Address address = new Address(null, objDTO.getNumber(), objDTO.getComplement(), objDTO.getDistrict(), objDTO.getPublicPlace(), objDTO.getZipCode(), costumer, city);
		costumer.getAddresses().add(address);
		costumer.getPhones().add(objDTO.getPhone1());
		if (objDTO.getPhone2() != null) {
			costumer.getPhones().add(objDTO.getPhone2());
		}
		if(objDTO.getPhone3() != null) {
			costumer.getPhones().add(objDTO.getPhone3());
		}
		return costumer;
	}
	
	private void updatedData (Costumer newObj, Costumer obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
	