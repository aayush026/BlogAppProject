package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
//JpaRepository<User, Integer> -> need to declare entity and type of primary key, we can use JpaRepository features for DB operations
	
	
	
	
	
}
