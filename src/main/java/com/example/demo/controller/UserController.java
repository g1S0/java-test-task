package com.example.demo.controller;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.PostDetailsDto;
import com.example.demo.dto.post.UserDto;
import com.example.demo.service.spec.IPostService;
import com.example.demo.service.spec.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllPosts() {
        List<UserDto> postDetails = service.findAll();

        return ResponseEntity.ok().body(postDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getPostById(@PathVariable Long id) {
        UserDto postDetailsDto = service.findById(id);

        return ResponseEntity.ok().body(postDetailsDto);
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDto> postRequest() {
        DefaultResponseDto defaultResponseDto = service.postRequest();

        return ResponseEntity.ok().body(defaultResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> puUserById(@PathVariable Long id) {
        DefaultResponseDto album = service.putUser(id);

        return ResponseEntity.ok().body(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        service.deleteUser(id);

        return ResponseEntity.ok().body("success");
    }

}
