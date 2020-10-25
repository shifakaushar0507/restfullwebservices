package com.examplerest.webservices.restfulwebservices.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.examplerest.webservices.restfulwebservices.user.User;

@RepositoryRestResource(path="userresource",collectionResourceRel = "User")

public interface UserRepository<T> extends PagingAndSortingRepository<User,Integer> {

}
