package com.fortheadvancementoflearning.blog.services;

import com.fortheadvancementoflearning.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);

}
