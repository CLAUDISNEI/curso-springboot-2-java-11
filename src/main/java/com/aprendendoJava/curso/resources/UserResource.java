package com.aprendendoJava.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendoJava.curso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> encontrarTodos() {
		
		User u = new User(2L, "João", "joao@gmail.com", "555", "5432");

		return ResponseEntity.ok().body(u);
	}
}
