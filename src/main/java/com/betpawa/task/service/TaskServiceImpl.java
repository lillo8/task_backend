package com.betpawa.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betpawa.task.dao.TaskDao;
import com.betpawa.task.model.Task;

@Service
@Transactional(readOnly = false)
public class TaskServiceImpl implements TaskService {
	 @Autowired
	 private TaskDao taskDao;

	@Override
	public Task get(long id) {
		// TODO Auto-generated method stub
		return taskDao.get(id);
	}

	@Override
	public List<Task> list() {
		return taskDao.list();
	}

	@Override
	public Task add(Task t) {
		return taskDao.add(t);
		
	}

	@Override
	public void delete(long id) {
		taskDao.delete(id);
		
	}

	@Override
	public Task update(Task t) {
		return taskDao.update(t);
	}

}
