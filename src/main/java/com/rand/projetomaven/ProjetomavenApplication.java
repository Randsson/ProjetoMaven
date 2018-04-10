package com.rand.projetomaven;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rand.projetomaven.domain.Address;
import com.rand.projetomaven.domain.Category;
import com.rand.projetomaven.domain.City;
import com.rand.projetomaven.domain.Costumer;
import com.rand.projetomaven.domain.ItemPedido;
import com.rand.projetomaven.domain.Payment;
import com.rand.projetomaven.domain.PaymentWithCCard;
import com.rand.projetomaven.domain.PaymentWithTicket;
import com.rand.projetomaven.domain.Pedido;
import com.rand.projetomaven.domain.Product;
import com.rand.projetomaven.domain.State;
import com.rand.projetomaven.domain.enums.CostumerKind;
import com.rand.projetomaven.domain.enums.PaymentStatus;
import com.rand.projetomaven.repositories.AddressRepository;
import com.rand.projetomaven.repositories.CategoryRepository;
import com.rand.projetomaven.repositories.CityRepository;
import com.rand.projetomaven.repositories.CostumerRepository;
import com.rand.projetomaven.repositories.ItemPedidoRepository;
import com.rand.projetomaven.repositories.PaymentRepository;
import com.rand.projetomaven.repositories.PedidoRepository;
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
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetomavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama mesa e banho ");
		Category cat4 = new Category(null, "Lazer");
		Category cat5 = new Category(null, "Jogos");
		Category cat6 = new Category(null, "Bazar");
		Category cat7 = new Category(null, "Higiene");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		Product p4 = new Product(null, "Mesa de escritório", 300.00);
		Product p5 = new Product(null, "Toalha", 50.00);
		Product p6 = new Product(null, "Colcha", 200.00);
		Product p7 = new Product(null, "Tv true color", 1200.00);
		Product p8 = new Product(null, "Roçadeira", 800.00);
		Product p9 = new Product(null, "Abajour", 100.00);
		Product p10 = new Product(null, "Pendente", 180.00);
		Product p11 = new Product(null, "Shampoo", 90.00);
		
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p2, p1, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));
				
		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));
		
		catRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6 ,p7, p8 ,p9, p10, p11));
		
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
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm"); //auxiliar para a data
		
		Pedido pedido = new Pedido(null, sdf.parse("30/09/2017 10:32"), costu1, addre1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),costu1, addre2);

		Payment pay1 = new PaymentWithCCard(null, PaymentStatus.QUITADO, pedido, 6);
		pedido.setPayment(pay1);
		
		Payment pay2 = new PaymentWithTicket(null, PaymentStatus.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPayment(pay2);
		
		costu1.getPedidos().addAll(Arrays.asList(pedido, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido, pedido2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		ItemPedido ip1 = new ItemPedido(pedido, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(pedido, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(pedido2, p2, 100.00, 1, 800.00);
		
		pedido.getItens().addAll(Arrays.asList(ip1, ip2));
		pedido2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
