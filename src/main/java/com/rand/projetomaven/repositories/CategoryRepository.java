package com.rand.projetomaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rand.projetomaven.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	

}
