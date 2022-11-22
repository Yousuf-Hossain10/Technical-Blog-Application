package com.fortheadvancementoflearning.blog.services.impl;

import com.fortheadvancementoflearning.blog.entities.Comment;
import com.fortheadvancementoflearning.blog.entities.Post;
import com.fortheadvancementoflearning.blog.exceptions.ResourceNotFoundException;
import com.fortheadvancementoflearning.blog.payloads.CommentDto;
import com.fortheadvancementoflearning.blog.repositories.CommentRepo;
import com.fortheadvancementoflearning.blog.repositories.PostRepo;
import com.fortheadvancementoflearning.blog.services.CommentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}

}

