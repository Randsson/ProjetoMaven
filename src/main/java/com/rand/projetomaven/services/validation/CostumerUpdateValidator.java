package com.rand.projetomaven.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.rand.projetomaven.domain.Costumer;
import com.rand.projetomaven.dto.CostumerDTO;
import com.rand.projetomaven.repositories.CostumerRepository;
import com.rand.projetomaven.resources.exceptions.FieldMessage;

public class CostumerUpdateValidator implements ConstraintValidator<CostumerUpdate, CostumerDTO>{
	
	@Autowired
	private HttpServletRequest request; //permite pegar os parametros passados no request
	
	@Autowired 
	private CostumerRepository repo;
		
	@Override
	public void initialize(CostumerUpdate ann) {
		
	}
	
	@Override
	public boolean isValid(CostumerDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		//inclua os testes aqui, inserindo erros na lista
			
		//pega as variáveis de URI que estão na requisição 
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE); 
		
		//pega o campo pretendido do request (que está em String), convertendo para inteiro.
		Integer uriId = Integer.parseInt(map.get("id"));
		Costumer aux = repo.findByEmail(objDTO.getEmail());
		
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		for (FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
		
		
	}
	
	

}
