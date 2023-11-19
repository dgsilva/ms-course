package com.api.hruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.hruser.entities.User;
import com.api.hruser.repositories.UserRepository;

@RefreshScope
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User>findById(@RequestParam String email){
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
