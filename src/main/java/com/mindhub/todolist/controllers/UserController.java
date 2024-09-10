package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.models.*;
import com.mindhub.todolist.repositories.UserRepository;
import org.apache.coyote.Response;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

@GetMapping
    public List<UserDTO> getUsers(){
     return userRepository.findAll().stream().map(UserDTO::new ).collect(Collectors.toList());
}

@PostMapping
    public ResponseEntity<?> createUser(CreateUserRequest request){
    if(request.email() != null && request.password() !=null && request.username()!=null){
        UserApp userApp = new UserApp(request.username(), request.password(), request.email());
        userRepository.save(userApp);
        return new ResponseEntity<>("User created Succesfully",HttpStatus.CREATED);
    }
    return new ResponseEntity<>("Error creating User",HttpStatus.BAD_REQUEST);


}


}
