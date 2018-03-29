package com.rand.projetomaven;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rand.projetomaven.domain.Address;
import com.rand.projetomaven.domain.Category;
import com.rand.projetomaven.domain.City;
import com.rand.projetomaven.domain.Costumer;
import com.rand.projetomaven.domain.Product;
import com.rand.projetomaven.domain.State;
import com.rand.projetomaven.domain.enums.CostumerKind;
import com.rand.projetomaven.repositories.AddressRepository;
import com.rand.projetomaven.repositories.CategoryRepository;
import com.rand.projetomaven.repositories.CityRepository;
import com.rand.projetomaven.repositories.CostumerRepository;
import com.rand.projetomaven.repositories.ProductRepository;
import com.rand.projetomaven.repositories.StateRepository;

@SpringBootApplication
public class ProjetomavenApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository catRepository;
	@Autowired
	private ProductRepository prodRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CostumerRepository costumerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetomavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		catRepository.saveAll(Arrays.asList(cat1, cat2));
		prodRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State est1 = new State(null, "Alagoas");
		State est2 = new State(null, "Pernambuco");
		
		City city1 = new City(null, "Maceió", est1);
		City city2 = new City(null, "Santo Amaro", est2);
		City city3 = new City(null, "Recife", est2);
		
		est1.getCities().addAll(Arrays.asList(city1));
		est2.getCities().addAll(Arrays.asList(city2, city3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		Costumer costu1 = new Costumer(null, "randsson", "randsson@com", "99999999", CostumerKind.PESSOAFISICA);
		costu1.getPhones().addAll(Arrays.asList("99999999", "88888889"));
		
		Address addre1 = new Address(null, "13", "complement", "ouro preto", "praça", "57045810", costu1, city1);
		Address addre2 = new Address(null, "15", "nada", "sei não", "zona", "57045830", costu1, city2);
		
		costu1.getAddresses().addAll(Arrays.asList(addre1, addre2));
		
		costumerRepository.saveAll(Arrays.asList(costu1));
		addressRepository.saveAll(Arrays.asList(addre1, addre2));
	}
}
