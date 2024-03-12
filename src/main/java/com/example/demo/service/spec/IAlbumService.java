package com.example.demo.service.spec;

import com.example.demo.dto.post.AlbumDto;
import com.example.demo.dto.post.DefaultResponseDto;

import java.util.List;

public interface IAlbumService {
    List<AlbumDto> findAll();

    AlbumDto findById(Long id);

    DefaultResponseDto postRequest();

    DefaultResponseDto putAlbum(Long id);

    void deleteAlbum(Long id);
}
