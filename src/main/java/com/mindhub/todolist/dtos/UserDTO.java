package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.UserApp;

public class UserDTO {
    private Long id;
    private String username,email;

    public UserDTO(UserApp userApp) {
        this.id = userApp.getId();
        this.username = userApp.getUsername();
        this.email = userApp.getEmail();
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
