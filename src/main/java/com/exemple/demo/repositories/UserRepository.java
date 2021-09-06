package com.exemple.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
