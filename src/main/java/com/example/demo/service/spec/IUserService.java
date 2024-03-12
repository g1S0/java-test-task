package com.example.demo.service.spec;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();

    UserDto findById(Long id);

    DefaultResponseDto postRequest();

    DefaultResponseDto putUser(Long id);

    void deleteUser(Long id);
}
