package com.felipe.training.springmusic.repository;

import com.felipe.training.springmusic.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
