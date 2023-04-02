package com.example.DB_task1.controller;

import com.example.DB_task1.model.User;
import com.example.DB_task1.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<User>> getTeachers(){
        return ResponseEntity.ok(this.userRepository.findAllByRoleID(3L));
    }
    @GetMapping("/students")
    public ResponseEntity<List<User>> getStudents(){
        return ResponseEntity.ok(this.userRepository.findAllByRoleID(1L));
    }
}
