package com.betpawa.task.service;

import java.util.List;

import com.betpawa.task.model.Comment;

public interface CommentService {
	List<Comment> list(long taskId);
	void delete(long id);
	Comment add(Comment c);
}
