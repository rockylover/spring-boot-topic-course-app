package com.example.demo.default1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@RequestMapping("/")
	public String defaultMethod() {
		return "Welcome to Spring Boot application";
	}

}
