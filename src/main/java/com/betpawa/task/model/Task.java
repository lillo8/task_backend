package com.betpawa.task.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private long taskId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	@Column(name="to_do_date")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+2")
	//set the same timezone of the mysql server in 
	//in order to prevent date shifts
	private Date toDoDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="task")
	private List<Comment> comments;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "priority_id", referencedColumnName = "priority_id")
	private Priority priority;
	
	
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public Date getToDoDate() {
		return toDoDate;
	}
	public void setToDoDate(Date toDoDate) {
		this.toDoDate = toDoDate;
	}
	public Task(long taskId, String title, String description) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
	}
	public Task(String title, String description, String priorityId) {
		super();
		this.title = title;
		this.description = description;
		this.priority.setPriorityId(Long.parseLong(priorityId));
	}
	
	public Task(long id) {
		super();
		this.taskId=id;
	}
	
	
	public Task() {
		super();
	}
	
	
	
}
