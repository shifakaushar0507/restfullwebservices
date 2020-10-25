package com.examplerest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int idCount = 4;
	
	static {
		users.add(new User(1,"kapil","developer",new Date()));
		users.add(new User(2,"shifa","developer",new Date()));
		users.add(new User(3,"ravi","developer",new Date()));
		users.add(new User(4,"jai","developer",new Date()));
	}

	//return all users
	public List<User> findAll(){
		return users;
	}
	
	//add user
	public User save (User user) {
		if(user.getId()== null) {
			user.setId(++idCount);
		}
		users.add(user);
		return user;
	}
	
	//retrieve specific user
	public User find(int id) {
		for (User user:users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;

	}
	//retrieve specific user
	public User delete(int id) {
	
		Iterator<User> it =users.iterator();
		while (it.hasNext()) {
			User user = it.next();
			if (user.getId()==id) {
				it.remove();
				return user;
			}
		}
		return null;

	}

}