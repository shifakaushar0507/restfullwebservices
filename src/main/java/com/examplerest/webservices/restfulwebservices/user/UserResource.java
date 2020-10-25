package com.examplerest.webservices.restfulwebservices.user;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.examplerest.webservice.exception.UserNotFoundException;
//
//@RestController
//public class UserResource {
//	 @Autowired
//	 private UserDaoService service;
//	///Get /users
//	//retrive all Users
//	 
//	 @GetMapping("/users")
//	public List<User>retriveAllUsers(){
//		return service.finalAll();
//		
//	}
//	 //Get /users/{id}
//	 
//	//retriveUser(int id)
//	 @GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//		 User user = service.findOne(id); 
//			
//			if(user==null) {
//				throw new UserNotFoundException("id :" +id);
//			}
//			return user;
//		
//	}
//	 
//	 //input-details of user
//	 //output-created &return the created URI
//	 @PostMapping("/users")
//	 public void createUser(@Valid @RequestBody User user) {
//		 User saveUser = service.save(user);
//		 
//	 }
//	 @DeleteMapping("/users/{id}")
//		public void deleteUser(@PathVariable int id) {
//			service.delete(id);
//}
//}
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examplerest.webservice.exception.UserNotFoundException;

@SuppressWarnings("deprecation")
@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	//retrieveAll user
	@GetMapping("/users")
	public  List<User> retrieveAll() {
		return service.findAll();
	}
	
	//retrieve one user
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieve(@PathVariable int id) {
		User user = service.find(id);
		 
		if (user== null)
	 
			throw new UserNotFoundException("id-" + id);
	 
		EntityModel<User> model = new EntityModel<>(user);
	 
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAll());
	 
		model.add(linkTo.withRel("all-users"));
	 
		return model;
	}
	
	//add new  user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
	User createdUser = service.save(user);
	 
	URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{id}").
		buildAndExpand(createdUser.getId()).
		toUri();
	return ResponseEntity.created(location).build();
	
	}
	
	//retrieveAllUsers
	
	
	//delete one user
		@DeleteMapping("/users/{id}")
		public void Delete(@PathVariable int id) {
			User user = service.delete(id); 
			
			if(user==null) {
				throw new UserNotFoundException("id :" +id);
			}
		
		}
		
}
