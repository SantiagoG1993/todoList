package com.mindhub.todolist;

import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.TaskStatus;
import com.mindhub.todolist.models.UserApp;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(TaskRepository taskRepository, UserRepository userRepository){
		return args ->{

			UserApp userApp1 = new UserApp("Santiago","123","santi@gmail.com");
			Task task1 = new Task("Estudiar","Estudiar durante 1 hora", TaskStatus.PENDING);

			userApp1.addTask(task1);
			userRepository.save(userApp1);
			taskRepository.save(task1);

		};
	}

}
