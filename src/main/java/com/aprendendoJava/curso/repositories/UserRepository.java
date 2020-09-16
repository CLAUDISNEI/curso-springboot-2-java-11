package com.aprendendoJava.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aprendendoJava.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
