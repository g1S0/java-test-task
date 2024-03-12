package com.example.demo.service.api.utils;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.PostDetailsDto;
import com.example.demo.dto.post.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserAPI {

    @Autowired
    private APIHandler apiHandler;

    public List<UserDto> findAll() {
        ResponseEntity<UserDto[]> response = apiHandler.callAPI(
                "/users",
                HttpMethod.GET,
                null,
                null,
                UserDto[].class
        );

        return List.of(Objects.requireNonNull(response.getBody()));
    }

    public UserDto findById(Long id) {
        ResponseEntity<UserDto> response = apiHandler.callAPI(
                "/users" + "/" + id,
                HttpMethod.GET,
                null,
                null,
                UserDto.class
        );

        return response.getBody();
    }

    public DefaultResponseDto postRequest() {
        ResponseEntity<DefaultResponseDto> response = apiHandler.callAPI(
                "/users",
                HttpMethod.POST,
                null,
                null,
                DefaultResponseDto.class
        );

        return response.getBody();
    }

    public DefaultResponseDto putUser(Long id) {
        ResponseEntity<DefaultResponseDto> response = apiHandler.callAPI(
                "/users" + '/' + id,
                HttpMethod.PUT,
                null,
                null,
                DefaultResponseDto.class
        );

        return response.getBody();
    }

    public void deleteUser(Long id) {
        apiHandler.callAPI(
                "/users" + "/" + id,
                HttpMethod.DELETE,
                null,
                null,
                null
        );
    }


}