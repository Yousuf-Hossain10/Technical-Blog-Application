package com.fortheadvancementoflearning.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortheadvancementoflearning.blog.entities.Comment;


public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}

