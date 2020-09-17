package com.aprendendoJava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aprendendoJava.curso.entities.Product;
import com.aprendendoJava.curso.services.ProductService;

/*
 * Essa classe é utilizada para acessar a camada de Resource
 * 
 */
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	/*
	 * cria uma dependência de Productservice, ou serja o ProductResouce
	 * depende do ProductService, porém deve ser registrada como 
	 * componente no ProductService.
	 */
	@Autowired
	public ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> encontrarTodos() {
		
		List<Product> lista = service.encontreTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	/*Informa que a requisição do tipo get ira aceitar 
	 * o id do usuário como parâmetro na url, mas 
	 * para o spring aceita isso é necessário informar
	 * a anotação @PathVariable em frente a variavel	 * 
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> encontrarPorId(@PathVariable Long id){
		Product obj = service.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
