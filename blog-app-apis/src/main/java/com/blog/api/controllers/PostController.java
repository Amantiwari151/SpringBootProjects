package com.blog.api.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.entities.Post;
import com.blog.api.payloads.PostDto;
import com.blog.api.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
//	create 
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto ,@PathVariable Integer userId,@PathVariable Integer categoryId){
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		
		
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);	
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postsByCategory,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}/users")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		
		List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postsByUser,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		
		List<PostDto> allPosts = this.postService.getAllPosts();
		
		return new ResponseEntity<List<PostDto>>(allPosts,HttpStatus.OK);
	}
	
	@GetMapping("/getPostById/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postById = this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
		
	}

}
