package com.rand.projetomaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rand.projetomaven.domain.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Integer> {
	
	

}