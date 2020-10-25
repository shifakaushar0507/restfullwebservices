package com.examplerest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {
 
	 private String message;
	
	/**
	 * @param message
	 */
	public HelloWorldBean(String message) {   // constructor
		super();
		this.message = message;
	}


	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	
}
