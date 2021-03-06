package com.aprendendoJava.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoJava.curso.entities.Product;

/*
 * essa interface já possui varios metodos
 * herdados de JpaRespository e não 
 * é necessário implementálos
 */

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
