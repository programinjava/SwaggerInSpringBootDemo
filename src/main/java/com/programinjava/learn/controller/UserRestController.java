package com.programinjava.learn.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.programinjava.learn.dto.User;
import com.programinjava.learn.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;
	

	
	@GetMapping("/user")
	public ResponseEntity<User> getUser(@RequestParam String username) {
		if(StringUtils.isEmpty(username)) 
			return ResponseEntity.badRequest().build();
		User user =userRepository.findByUsername(username);
		return ResponseEntity.ok(user);
		
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody User user ,BindingResult errors , HttpServletRequest request){
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().build();			
		}
		User user1 = userRepository.save(user);
		URI location = new UriTemplate(request.getRequestURI() + "/{id}").expand(user1.getId());
		return ResponseEntity.created(location).build();
		
	}
}
