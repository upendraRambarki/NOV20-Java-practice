package com.upendra.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@GetMapping("/hello")
	public String HelloWorld()
	{
		return "hello upendra";
	}
}
