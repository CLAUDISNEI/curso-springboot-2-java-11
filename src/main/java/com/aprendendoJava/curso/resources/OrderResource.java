package com.aprendendoJava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aprendendoJava.curso.entities.Order;
import com.aprendendoJava.curso.services.OrderService;

/*
 * Essa classe é utilizada para acessar a camada de Resource
 * 
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	/*
	 * cria uma dependência de Orderservice, ou serja o OrderResouce
	 * depende do OrderService, porém deve ser registrada como 
	 * componente no OrderService.
	 */
	@Autowired
	public OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> encontrarTodos() {
		
		List<Order> lista = service.encontreTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	/*Informa que a requisição do tipo get ira aceitar 
	 * o id do usuário como parâmetro na url, mas 
	 * para o spring aceita isso é necessário informar
	 * a anotação @PathVariable em frente a variavel	 * 
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> encontrarPorId(@PathVariable Long id){
		Order obj = service.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
