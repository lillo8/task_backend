package com.betpawa.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.betpawa.task.model.Comment;
import com.betpawa.task.model.Task;
import com.betpawa.task.service.CommentService;
import com.betpawa.task.service.TaskService;

@RestController
@CrossOrigin
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private CommentService commentService;

	// info about a singular task
	@RequestMapping(value = "/task/{idTask}", method = RequestMethod.GET)
	public Task task(@PathVariable("idTask") long id) {
		Task task = taskService.get(id);
		return task;
		// return new Task(id,"ciao", "Test");
	}

	// list all tasks
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<Task> tasks() {
		return taskService.list();
	}



	@RequestMapping(value = "/task/{idTask}/comment", method = RequestMethod.POST)
	public Comment addComment(@PathVariable("idTask") long id, @ModelAttribute("comment") Comment c) {
		c.setTask(new Task(id));
		Comment result = commentService.add(c);
		return result;
	}
	
	// delete an exising task
	@RequestMapping(value = "/task/{idTask}", method = RequestMethod.DELETE)
	public Task deleteTask(@PathVariable("idTask") long id) {
		taskService.delete(id);
		return (new Task(id));
		// return new Task(id,"ciao", "Test");
	}

	
	// add a new task
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public Task addTask(@ModelAttribute("task") Task t) {
		Task result = null;
		if (t.getTaskId()==0) {
			result = taskService.add(t);
		}else {
			result = taskService.get(t.getTaskId());
			if (t.getDescription()!=null &&(!t.getDescription().equals(result.getDescription())))
				result.setDescription(t.getDescription());
			if (t.getTitle()!=null && (!t.getTitle().equals(result.getTitle())))
				result.setTitle(t.getTitle());
			if (t.getPriority()!=null && (t.getPriority().getPriorityId()!=result.getPriority().getPriorityId()))
				result.getPriority().setPriorityId(t.getPriority().getPriorityId());
			if (t.getToDoDate()!=null && (t.getToDoDate()!=result.getToDoDate()))
				result.setToDoDate(t.getToDoDate());
			taskService.update(result);
		}
		return result;
	}
	
	
	@RequestMapping(value = "/task/{idTask}/comments", method = RequestMethod.GET)
	public List<Comment> listComments(@PathVariable("idTask") long id){
		List<Comment> result = commentService.list(id);
		return result;
	}
	
	@RequestMapping(value = "/comment/{idComment}", method = RequestMethod.DELETE)
	public Comment deleteComment(@PathVariable("idComment") long id) {
		commentService.delete(id);
		return (new Comment(id));
	}
	
	// add a new task
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public Comment addComment(@ModelAttribute("comment") Comment c) {
		Comment result = null;
		result = commentService.add(c);
		return result;
	}
	
	

}
