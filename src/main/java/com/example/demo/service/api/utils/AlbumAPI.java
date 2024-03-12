package com.example.demo.service.api.utils;

import com.example.demo.dto.post.AlbumDto;
import com.example.demo.dto.post.DefaultResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AlbumAPI {

    @Autowired
    private APIHandler apiHandler;

    public List<AlbumDto> findAll() {
        ResponseEntity<AlbumDto[]> response = apiHandler.callAPI(
                "/albums",
                HttpMethod.GET,
                null,
                null,
                AlbumDto[].class
        );

        return List.of(Objects.requireNonNull(response.getBody()));
    }

    public AlbumDto findById(Long id) {
        ResponseEntity<AlbumDto> response = apiHandler.callAPI(
                "/albums" + "/" + id,
                HttpMethod.GET,
                null,
                null,
                AlbumDto.class
        );

        return response.getBody();
    }

    public DefaultResponseDto postRequest() {
        ResponseEntity<DefaultResponseDto> response = apiHandler.callAPI(
                "/albums",
                HttpMethod.POST,
                null,
                null,
                DefaultResponseDto.class
        );

        return response.getBody();
    }

    public DefaultResponseDto putPost(Long id) {
        ResponseEntity<DefaultResponseDto> response = apiHandler.callAPI(
                "/albums" + '/' + id,
                HttpMethod.PUT,
                null,
                null,
                DefaultResponseDto.class
        );

        return response.getBody();
    }

    public void deletePost(Long id) {
        apiHandler.callAPI(
                "/albums" + "/" + id,
                HttpMethod.DELETE,
                null,
                null,
                null
        );
    }


}