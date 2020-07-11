package com.betpawa.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betpawa.task.dao.CommentDao;
import com.betpawa.task.model.Comment;

@Service
@Transactional(readOnly = false)
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Comment> list(long taskId) {
		return commentDao.list(taskId);
	}

	@Override
	public void delete(long id) {
		commentDao.delete(id);
		
	}

	@Override
	public Comment add(Comment c) {
		return commentDao.add(c);
	}
	
	

}
