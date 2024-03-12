package com.example.demo.controller;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.PostDetailsDto;
import com.example.demo.service.spec.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    IPostService service;

    @GetMapping
    public ResponseEntity<List<PostDetailsDto>> getAllPosts() {
        List<PostDetailsDto> postDetails = service.findAll();

        return ResponseEntity.ok().body(postDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailsDto> getPostById(@PathVariable Long id) {
        PostDetailsDto postDetailsDto = service.findById(id);

        return ResponseEntity.ok().body(postDetailsDto);
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDto> postRequest() {
        DefaultResponseDto defaultResponseDto = service.postRequest();

        return ResponseEntity.ok().body(defaultResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> putPostById(@PathVariable Long id) {
        DefaultResponseDto postDetailsDto = service.putPost(id);

        return ResponseEntity.ok().body(postDetailsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        service.deletePost(id);

        return ResponseEntity.ok().body("success");
    }

}
