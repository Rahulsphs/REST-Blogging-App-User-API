package com.codewithrahul.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithrahul.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	

}
