package com.codewithrahul.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithrahul.blog.payloads.ApiResponse;
import com.codewithrahul.blog.payloads.UserDto;
import com.codewithrahul.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST- Create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	// PUT- Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}

	// GET- Retrieve user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
		UserDto foundUser = this.userService.getUserById(userId);
		return ResponseEntity.ok(foundUser);

	}

	// DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully", true), HttpStatus.OK);

	}
	
	// GET- Retrieve all user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
	return ResponseEntity.ok(userService.getAllUser());
				
	}
}
