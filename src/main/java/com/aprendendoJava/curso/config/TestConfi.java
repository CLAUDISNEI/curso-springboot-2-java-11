package com.aprendendoJava.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprendendoJava.curso.entities.Category;
import com.aprendendoJava.curso.entities.Order;
import com.aprendendoJava.curso.entities.User;
import com.aprendendoJava.curso.entities.enums.OrderStatus;
import com.aprendendoJava.curso.repositories.CategoryRepository;
import com.aprendendoJava.curso.repositories.OrderRepository;
import com.aprendendoJava.curso.repositories.UserRepository;

/*
 * Essa classe será utilizada para realizar
 * o teste de atualização dos dados no BD
 */
@Configuration
@Profile("test")
public class TestConfi implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	/*
	 * fazendo o seed da tabela Order para 
	 * carregar alguns valores na tabela
	 */

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//o formato de data abaixo é o Iso8601
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID , u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITTING_PAYMENT , u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITTING_PAYMENT , u1);
		
		//criando algumas categorias
		Category cat1 = new Category(null, "Computers");
		Category cat2 = new Category(null, "Music");
		Category cat3 = new Category(null, "Food");
		Category cat4 = new Category(null, "Cars");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
}
