package com.rand.projetomaven;

//import org.assertj.core.util.Arrays;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rand.projetomaven.domain.Category;
import com.rand.projetomaven.repositories.CategoryRepository;

@SpringBootApplication
public class ProjetomavenApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository catRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetomavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "informática");
		Category cat2 = new Category(null, "Escritório");
		
		catRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
