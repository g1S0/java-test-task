package com.example.demo.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlbumDto {
    @lombok.NonNull
    final int userId;
    @lombok.NonNull
    final int id;
    @lombok.NonNull
    final String title;
}

