package com.example.demo.service.spec;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.PostDetailsDto;

import java.util.List;

public interface IPostService {
    List<PostDetailsDto> findAll();
    PostDetailsDto findById(Long id);

    DefaultResponseDto postRequest();

    DefaultResponseDto putPost(Long id);

    void deletePost(Long id);
}
