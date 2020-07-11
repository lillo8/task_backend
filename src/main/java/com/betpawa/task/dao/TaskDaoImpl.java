package com.betpawa.task.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.betpawa.task.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao{
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Task get(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Task task = session.get(Task.class, id);
		//Hibernate.initialize(task.getComments());
		return task;
	}


	@Override
	public List<Task> list() {
		Session session = sessionFactory.getCurrentSession();
		List<Task> result = session.createQuery("from Task").list();
		return result;
	}


	@Override
	public Task add(Task t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		return t;
	}
	
	public Task update(Task t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		return t;		
	}


	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(new Task(id));
		
	}
	
	



	
	
	
	

}
