package com.betpawa.task;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class TaskApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TaskApplication.class, args);
		
        SpringApplication app = new SpringApplication(TaskApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
		
	}

}
