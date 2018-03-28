package com.rand.projetomaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rand.projetomaven.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	

}
