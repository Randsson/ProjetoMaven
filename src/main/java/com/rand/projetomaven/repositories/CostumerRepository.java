package com.rand.projetomaven.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rand.projetomaven.domain.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Integer> {
	
	
	@Transactional(readOnly = true)
	Costumer findByEmail(String email);
	
}
