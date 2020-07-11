package com.betpawa.task.dao;

import java.util.List;

import com.betpawa.task.model.Comment;


public interface CommentDao {
	List<Comment> list(long taskId);
	void delete(long id);
	Comment add(Comment c);

}
