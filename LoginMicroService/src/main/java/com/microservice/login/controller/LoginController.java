package com.microservice.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class LoginController {

	
	 @Autowired
	  RestTemplate restTemplate;

	  @Autowired
	  private DiscoveryClient discoveryClient;
	  
	  
	  @RequestMapping("/user")
	  public String hi(@RequestParam(value="name", defaultValue="Artaban") String name) {


	    //For example only. Shows our list of instances
	    final List<ServiceInstance> instances = this.discoveryClient.getInstances("sayhello");
	    for(final ServiceInstance instance : instances){
	      System.out.println("Instance: " + instance.getHost());
	      System.out.println("Port: " + instance.getPort());
	      System.out.println("URI: " + instance.getUri().toString());
	    }

	    //TODO: Wrap this with Hystrix
	    //=====================================
	    final String greeting = this.restTemplate.getForObject("http://sayhello/greeting", String.class);
	    //=====================================


	    return String.format("%s, %s!", greeting, name);
	  }
	  
	  
	  @RequestMapping("/login")
	  public String login() {


	    //For example only. Shows our list of instances
	    final List<ServiceInstance> instances = this.discoveryClient.getInstances("admin");
	    for(final ServiceInstance instance : instances){
	      System.out.println("Instance: " + instance.getHost());
	      System.out.println("Port: " + instance.getPort());
	      System.out.println("URI: " + instance.getUri().toString());
	    }

	    //TODO: Wrap this with Hystrix
	    //=====================================
	    final String greeting = this.restTemplate.getForObject("http://admin/greeting", String.class);
	    //=====================================


	    return greeting;
	  }
}
