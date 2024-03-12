package com.example.demo.service.impl;

import com.example.demo.dto.post.AlbumDto;
import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.service.api.utils.APILayer;
import com.example.demo.service.spec.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    APILayer apiLayer;

    @Cacheable("albums")
    @Override
    public List<AlbumDto> findAll() {
        return apiLayer.getAlbumAPI().findAll();
    }

    @Cacheable(value = "album", key = "#id")
    @Override
    public AlbumDto findById(Long id) {
        return apiLayer.getAlbumAPI().findById(id);
    }

    @CachePut(value = "album", key = "#result.id")
    @Override
    public DefaultResponseDto postRequest() {
        return apiLayer.getAlbumAPI().postRequest();
    }

    @CachePut(value = "album", key = "#id")
    @Override
    public DefaultResponseDto putAlbum(Long id) {
        return apiLayer.getAlbumAPI().putPost(id);
    }

    @CacheEvict(value = "album", key = "#id")
    @Override
    public void deleteAlbum(Long id) {
        apiLayer.getAlbumAPI().deletePost(id);
    }
}
