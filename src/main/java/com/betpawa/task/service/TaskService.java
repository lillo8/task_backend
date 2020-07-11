package com.betpawa.task.service;

import java.util.List;

import com.betpawa.task.model.Task;

public interface TaskService {
	Task get(long id);
	List<Task> list();
	Task add(Task t);
	void delete(long id);
	Task update(Task t);
}
