package com.rand.projetomaven.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rand.projetomaven.domain.Category;

public class CategoryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preechimento obrigat´rio")
	@Length(min=5, max=80, message="Entre 5 e 80 caracteres")
	private String name;

	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Category obj) {
		
		id = obj.getId();
		name = obj.getName();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
