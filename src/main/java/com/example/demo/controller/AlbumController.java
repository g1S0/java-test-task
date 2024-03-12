package com.example.demo.controller;

import com.example.demo.dto.post.AlbumDto;
import com.example.demo.dto.post.DefaultResponseDto;
import com.example.demo.service.spec.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    IAlbumService service;

    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAllAlbums() {
        List<AlbumDto> albumDetails = service.findAll();

        return ResponseEntity.ok().body(albumDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> getAlbumById(@PathVariable Long id) {
        AlbumDto albumDto = service.findById(id);

        return ResponseEntity.ok().body(albumDto);
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDto> postRequest() {
        DefaultResponseDto defaultResponseDto = service.postRequest();

        return ResponseEntity.ok().body(defaultResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDto> puAlbumById(@PathVariable Long id) {
        DefaultResponseDto album = service.putAlbum(id);

        return ResponseEntity.ok().body(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbumById(@PathVariable Long id) {
        service.deleteAlbum(id);

        return ResponseEntity.ok().body("success");
    }

}
