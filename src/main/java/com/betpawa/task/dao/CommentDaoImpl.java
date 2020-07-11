package com.betpawa.task.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.betpawa.task.model.Comment;
import com.betpawa.task.model.Task;

@Repository
public class CommentDaoImpl implements CommentDao{
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Comment> list(long taskId) {
		String hqlQuery = "from Comment C where C.task.taskId = :taskid";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hqlQuery);
		query.setParameter("taskid", taskId);
		List<Comment> result = query.list();
		return result;
	}


	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(new Comment(id));		
	}


	@Override
	public Comment add(Comment c) {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		return c;
	}

}
