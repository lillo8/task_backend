package com.betpawa.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="priority")
public class Priority {
	
	@Id
	@Column(name="priority_id")
	private long priorityId;
	
	@Column(name="priority_desc")
	private String priorityDesc;


	
	@OneToOne(mappedBy="priority")
	private Task task;
	
	
	public long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityDesc() {
		return priorityDesc;
	}

	public void setPriorityDesc(String priorityDesc) {
		this.priorityDesc = priorityDesc;
	}

	
	
}
