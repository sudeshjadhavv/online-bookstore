package com.sudesh.bookstore.controller;

	import com.sudesh.bookstore.entity.User;
	import com.sudesh.bookstore.services.AuthService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("/api/auth")
	public class AuthController {

	    @Autowired
	    private AuthService authService;

	    // REGISTER
	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody User user) {
	        String message = authService.register(user);
	        return ResponseEntity.ok(message);
	    }

	    // LOGIN
	    @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody User user) {
	        String token = authService.login(user.getUsername(), user.getPassword());
	        return ResponseEntity.ok("Bearer " + token);
	    }
	}


