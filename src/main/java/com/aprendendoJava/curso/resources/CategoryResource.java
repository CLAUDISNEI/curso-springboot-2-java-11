package com.aprendendoJava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendoJava.curso.entities.Category;
import com.aprendendoJava.curso.services.CategoryService;

/*
 * Essa classe é utilizada para acessar a camada de Resource
 * 
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	/*
	 * cria uma dependência de Categoryservice, ou serja o CategoryResouce
	 * depende do CategoryService, porém deve ser registrada como 
	 * componente no CategoryService.
	 */
	@Autowired
	public CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> encontrarTodos() {
		
		List<Category> lista = service.encontreTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	/*Informa que a requisição do tipo get ira aceitar 
	 * o id do usuário como parâmetro na url, mas 
	 * para o spring aceita isso é necessário informar
	 * a anotação @PathVariable em frente a variavel	 * 
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> encontrarPorId(@PathVariable Long id){
		Category obj = service.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
