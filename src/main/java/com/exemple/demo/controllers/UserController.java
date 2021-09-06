package com.exemple.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.demo.entities.User;
import com.exemple.demo.repositories.UserRepository;

@RestController 		//para mostrar que vai ser um controlador rest
@RequestMapping(value = "/users")
public class UserController {

	//esse componente sera injetado automáticamente
	@Autowired
	private UserRepository repository;

	
	//Esse método irá buscar todos os dados do bd 
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
	    List<User> result = repository.findAll();
	    return ResponseEntity.ok(result);
	}
	
	//esse método irá retornar page (quantidade de itens por página) do caminho /users/page
	@GetMapping(value = "/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable){
		Page<User> result = repository.findAll(pageable);		
		return ResponseEntity.ok(result);		
	}	
	
	
}
