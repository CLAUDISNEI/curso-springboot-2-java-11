package com.aprendendoJava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprendendoJava.curso.entities.Category;
import com.aprendendoJava.curso.repositories.CategoryRepository;

/*
 * A notação @Service serve para informar que essa classe
 * será utiliada como componente em outras classes que dependem
 * dela
 */
@Service
public class CategoryService {
	
	/*@Autowired - essa notação cria uma
	 *  injeção de dependencia. 
	 *  Ou seja será instanciado
	 * um objeto do tipo UsrRepository 
	 */
	@Autowired
	private CategoryRepository repository;
	
	/*
	 * Um metodo que retorna todos os
	 * usuarios do banco de dados
	 */
	public List<Category> encontreTodos(){
		return repository.findAll();
	}
	
	/*
	 * Metodo utilizado para retornar o usuário pelo id
	 */
	public Category encontrarPorId(Long Id) {
		/*
		 * O tipo Optional recebe um objeto qualquer 
		 * e caso a busca não retorne resultado o valor
		 * automaticamente será nulo
		 */
		Optional<Category> obj = repository.findById(Id);
		/*
		 * a operação get do Optional irá retornar o obj
		 * localizado pelo metodo findById
		 */
		return obj.get();
	}
	
	
}	

