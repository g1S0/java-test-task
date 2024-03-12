package com.example.demo.service.api.utils;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.PostDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PostAPI {

    @Autowired
    private APIHandler apiHandler;

    public List<PostDetailsDto> findAll() {
        ResponseEntity<PostDetailsDto[]> response = apiHandler.callAPI(
                "/posts",
                HttpMethod.GET,
                null,
                null,
                PostDetailsDto[].class
        );

        return List.of(Objects.requireNonNull(response.getBody()));
    }

    public PostDetailsDto findById(Long id) {
        ResponseEntity<PostDetailsDto> response = apiHandler.callAPI(
                "/posts" + "/" + id,
                HttpMethod.GET,
                null,
                null,
                PostDetailsDto.class
        );

        return response.getBody();
    }

    public DefaultResponseDto postRequest() {
        ResponseEntity<DefaultResponseDto> response = apiHandler.callAPI(
                "/posts",
                HttpMethod.POST,
                null,
                null,
                DefaultResponseDto.class
        );

        return response.getBody();
    }

    public DefaultResponseDto putPost(Long id) {
        ResponseEntity<DefaultResponseDto> response = apiHandler.callAPI(
                "/posts" + '/' + id,
                HttpMethod.PUT,
                null,
                null,
                DefaultResponseDto.class
        );

        return response.getBody();
    }

    public void deletePost(Long id) {
        apiHandler.callAPI(
                "/posts" + "/" + id,
                HttpMethod.DELETE,
                null,
                null,
                null
        );
    }


}