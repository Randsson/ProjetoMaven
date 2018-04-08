package com.rand.projetomaven.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy= CostumerInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)


public @interface CostumerInsert {
	
	String message() default "Erro d validação";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {} ;	
}