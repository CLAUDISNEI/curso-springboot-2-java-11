package com.aprendendoJava.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoJava.curso.entities.Order;

/*
 * essa interface já possui varios metodos
 * herdados de JpaRespository e não 
 * é necessário implementálos
 */

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
