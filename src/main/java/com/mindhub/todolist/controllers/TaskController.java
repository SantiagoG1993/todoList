package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.models.CreateTaskRequest;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.TaskStatus;
import com.mindhub.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<TaskDTO> getTasks(){
        return taskRepository.findAll().stream().map(TaskDTO::new).collect(Collectors.toList());
    };

    @PostMapping
    public ResponseEntity<String> createTask(CreateTaskRequest createTaskRequest){
        if(createTaskRequest.title()!= null && createTaskRequest.description() != null){
            Task task = new Task(createTaskRequest.title(), createTaskRequest.description(), TaskStatus.PENDING);
            taskRepository.save(task);
            return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("Error creating task", HttpStatus.BAD_REQUEST);
    };
}
