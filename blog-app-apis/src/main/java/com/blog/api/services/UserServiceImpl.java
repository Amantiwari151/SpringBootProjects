package com.blog.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.exceptions.*;
import com.blog.api.entities.User;
import com.blog.api.payloads.UserDto;
import com.blog.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		User dtoToUser = dtoToUser(user);
		User savedUser = this.userRepo.save(dtoToUser);
		
		UserDto userToDto = userToDto(savedUser);
		return userToDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User getUser = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		
		
		return this.userToDto(getUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = userRepo.findAll();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		users.forEach(x->{

			UserDto userToDto = userToDto(x);
			
			if(Objects.nonNull(userDtoList)) {
				userDtoList.add(userToDto);
				System.out.println(userDtoList.toString());
			}
		});
		
//		List<UserDto> collect = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtoList;
	} 

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		this.userRepo.delete(user);
		
	}
	
//	converting userdto into user
	private User dtoToUser(UserDto dto) {
		
		User user = this.modelMapper.map(dto,User.class);
//		user.setId(dto.getId());
//		user.setName(dto.getName());
//		user.setEmail(dto.getEmail());
//		user.setPassword(dto.getPassword());
//		user.setAbout(dto.getAbout());
		
		return user;
	}
	
//	convert user into userDto
	
	private  UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
}
