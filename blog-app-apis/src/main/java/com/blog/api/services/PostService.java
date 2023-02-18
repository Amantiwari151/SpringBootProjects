package com.blog.api.services;

import java.util.List;

import com.blog.api.entities.Post;
import com.blog.api.payloads.PostDto;

public interface PostService {
//	save post
	public PostDto createPost(PostDto postDto, Integer userId,Integer categoryId);
	
//	all posts
	public List<PostDto>  getAllPosts();
	
//	update post
	public Post updatePost(PostDto postDto,Integer postId);
	
//	delete post
	
	public void deletePost(Integer postId);
	
//	getSinglePost
	public PostDto getPostById(Integer postId);
	
//	getPostByCategory
	
	public List<PostDto> getPostsByCategory(Integer categoryId);
	
//	getPostByUser
	
	public List<PostDto> getPostsByUser(Integer userId);

}
