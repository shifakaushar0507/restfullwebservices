package com.examplerest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class HelloWorldcontroller {
	//get
	
	
	@GetMapping(path= "/Hello" )
	public String Hello() {
		return "Hello World";
		
	}
	@GetMapping(path= "/bean" )
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
		
	}
	@GetMapping(path= "/bean/path-variable/{name}/users")//
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World,%s",name));
		
	}

}
