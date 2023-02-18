package com.blog.api.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.blog.api.payloads.ApiResponse;
import com.blog.api.payloads.UserDto;
import com.blog.api.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createUser = this.userService.createUser(userDto);
		
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
		
	}
	
	
//	PUT - update 
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto ,@PathVariable Integer userId){
		
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		
		return ResponseEntity.ok(updateUser);
	}
	
	
	
//	Delete - delete user
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		
		this.userService.deleteUser(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}
	
//	GET - get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		List<UserDto> allUsers = this.userService.getAllUsers();
		
		return ResponseEntity.ok(allUsers);
		
	}
	
	@GetMapping("/singleUser/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		
		UserDto userById = this.userService.getUserById(userId);
		
		return ResponseEntity.ok(userById);
	}
	
}
