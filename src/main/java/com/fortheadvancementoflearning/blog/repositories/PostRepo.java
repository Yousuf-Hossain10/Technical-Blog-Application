package com.fortheadvancementoflearning.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortheadvancementoflearning.blog.entities.Categories;
import com.fortheadvancementoflearning.blog.entities.Post;
import com.fortheadvancementoflearning.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Categories category);
	List <Post> findByTitleContaining(String title);
}
