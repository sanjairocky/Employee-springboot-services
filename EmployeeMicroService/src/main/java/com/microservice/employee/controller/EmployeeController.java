package com.microservice.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@RequestMapping("/employee")
	public String hi(@RequestParam(value = "name", defaultValue = "Employee",required=false) String name) {

		return "Hello "+name+"!";
	}
	
}
