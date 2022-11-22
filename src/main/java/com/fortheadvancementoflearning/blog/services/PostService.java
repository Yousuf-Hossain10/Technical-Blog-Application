package com.fortheadvancementoflearning.blog.services;

import java.util.List;

import com.fortheadvancementoflearning.blog.payloads.PostDto;
import com.fortheadvancementoflearning.blog.payloads.PostResponse;

public interface PostService {

	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	public void deletePost (Integer postId);
	
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	
	public PostDto getPostById (Integer postId);
	
	//Get post by category
	public List<PostDto> getPostByCategory (Integer categoryId);
    
	//Get post by users
    public List<PostDto> getPostByUser (Integer userId);
    
    //Get post by keyword
    public List<PostDto> getPostByKeyword (String keyword);
    
}
