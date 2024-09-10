package com.mindhub.todolist.models;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username,password,email;
    @OneToMany(mappedBy = "userApp")
    private Set<Task> tasks = new HashSet<>();

    public UserApp(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserApp() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task){
        tasks.add(task);
        task.setUser(this);
    }
}
