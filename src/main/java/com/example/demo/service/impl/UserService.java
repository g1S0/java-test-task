package com.example.demo.service.impl;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.UserDto;
import com.example.demo.service.api.utils.APILayer;
import com.example.demo.service.spec.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    APILayer apiLayer;

    @Cacheable("users")
    @Override
    public List<UserDto> findAll() {
        return apiLayer.getUserAPI().findAll();
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public UserDto findById(Long id) {
        return apiLayer.getUserAPI().findById(id);
    }

    @CachePut(value = "user", key = "#result.id")
    public DefaultResponseDto postRequest() {
        return apiLayer.getUserAPI().postRequest();
    }

    @CachePut(value = "user", key = "#id")
    public DefaultResponseDto putUser(Long id) {
        return apiLayer.getUserAPI().putUser(id);
    }

    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(Long id) {
        apiLayer.getUserAPI().deleteUser(id);
    }
}
