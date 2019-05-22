package com.microservice.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@RequestMapping("/admin")
	public String hi(@RequestParam(value = "name", defaultValue = "Admin",required=false) String name) {

		return "Hello "+name+"!";
	}

}
