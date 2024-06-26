package com.felipe.training.springmusic.repository;

import com.felipe.training.springmusic.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
    Optional<Artist> findByNameContainingIgnoreCase(String name);
}
