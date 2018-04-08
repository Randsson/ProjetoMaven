package com.rand.projetomaven.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.rand.projetomaven.domain.enums.CostumerKind;
import com.rand.projetomaven.dto.CostumerNewDTO;
import com.rand.projetomaven.resources.exceptions.FieldMessage;
import com.rand.projetomaven.services.validation.utils.BR;

public class CostumerInsertValidator implements ConstraintValidator<CostumerInsert, CostumerNewDTO>{
	
	@Override
	public void initialize(CostumerInsert ann) {
		
	}
	
	@Override
	public boolean isValid(CostumerNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		//inclua os testes aqui, inserindo erros na lista
		
		if(objDTO.getKind().equals(CostumerKind.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		
		if(objDTO.getKind().equals(CostumerKind.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		for (FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
		
		
	}
	
	

}
