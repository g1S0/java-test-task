package com.example.demo.service.api.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APILayer {

    @Autowired
    private PostAPI postAPI;
    @Autowired
    private AlbumAPI albumAPI;
    @Autowired
    private UserAPI userAPI;

    public PostAPI getPostAPI() {
        return postAPI;
    }

    public AlbumAPI getAlbumAPI() {
        return albumAPI;
    }

    public UserAPI getUserAPI() {
        return userAPI;
    }
}
