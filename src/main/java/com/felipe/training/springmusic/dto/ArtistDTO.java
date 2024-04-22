package com.felipe.training.springmusic.dto;

import com.felipe.training.springmusic.model.ArtistType;

import java.util.List;

public record ArtistDTO(Long id,
                        String name,
                        ArtistType type,
                        List<MusicDTO> musics) {
}
