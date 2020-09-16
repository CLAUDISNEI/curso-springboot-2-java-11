package com.aprendendoJava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aprendendoJava.curso.entities.User;
import com.aprendendoJava.curso.services.UserService;

/*
 * Essa classe é utilizada para acessar a camada de Resource
 * 
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	/*
	 * cria uma dependência de Userservice, ou serja o UserResouce
	 * depende do UserService, porém deve ser registrada como 
	 * componente no UserService.
	 */
	@Autowired
	public UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> encontrarTodos() {
		
		List<User> lista = service.encontreTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	/*Informa que a requisição do tipo get ira aceitar 
	 * o id do usuário como parâmetro na url, mas 
	 * para o spring aceita isso é necessário informar
	 * a anotação @PathVariable em frente a variavel	 * 
	 */
	@GetMapping(value = "/(id)")
	public ResponseEntity<User> encontrarPorId(@PathVariable Long id){
		User obj = service.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
