package com.blog.api.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entities.Category;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.payloads.PostDto;
import com.blog.api.payloads.UserDto;
import com.blog.api.repositories.CategoryRepository;
import com.blog.api.repositories.PostRepository;
import com.blog.api.repositories.UserRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PostDto createPost(PostDto postDto , Integer userId,Integer categoryId) {
		
		Post post = this.mapper.map(postDto,Post.class);
		
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		
		post.setImage("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post savePost = this.postRepo.save(post);
		PostDto mapDto = this.mapper.map(savePost, PostDto.class);
		
		
		return mapDto;
	}

	@Override
	public List<PostDto> getAllPosts() {
		
		List<Post> getAllPost = this.postRepo.findAll();
		
		List<PostDto> collectedListDto = getAllPost.stream().map(post -> this.mapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		
		return collectedListDto;
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId" ,postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		
		Post savePost = this.postRepo.save(post);
		
		return savePost;
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
		
		this.postRepo.delete(post);
		
	}
	
	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
		
		PostDto postDto = this.mapper.map(post,PostDto.class);
		
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		 
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		
		List<Post> findByCategory = this.postRepo.findByCategory(category);
		
//		findByCategory.forEach(()-> this.mapper.map(findByCategory, PostDto.class));
		List<PostDto> postDtoList = findByCategory.stream().map(post-> this.mapper.map(post,PostDto.class)).collect(Collectors.toList());
	
//		CategoryDto categoryDto = this.mapper.map(category,CategoryDto.class);
		
		return postDtoList;  
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
		
		List<Post> findByUser = this.postRepo.findByUser(user);
		
		List<PostDto> userPostDtoList = findByUser.stream().map(post -> this.mapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return userPostDtoList;
	}

}
