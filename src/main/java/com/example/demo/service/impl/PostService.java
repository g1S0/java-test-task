package com.example.demo.service.impl;

import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.dto.post.PostDetailsDto;
import com.example.demo.service.api.utils.APILayer;
import com.example.demo.service.spec.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    private APILayer apiLayer;

    @Cacheable("posts")
    @Override
    public List<PostDetailsDto> findAll() {
        return apiLayer.getPostAPI().findAll();
    }

    @Cacheable(value = "post", key = "#id")
    @Override
    public PostDetailsDto findById(Long id) {
        return apiLayer.getPostAPI().findById(id);
    }

    @CachePut(value = "post", key = "#result.id")
    @Override
    public DefaultResponseDto postRequest() {
        return apiLayer.getPostAPI().postRequest();
    }

    @CachePut(value = "post", key = "#id")
    @Override
    public DefaultResponseDto putPost(Long id) {
        return apiLayer.getPostAPI().putPost(id);
    }

    @CacheEvict(value = "post", key = "#id")
    @Override
    public void deletePost(Long id) {
        apiLayer.getPostAPI().deletePost(id);
    }
}
