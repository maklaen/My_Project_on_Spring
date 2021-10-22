package com.pet.repository;

import com.pet.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Optional<Video> findByUserId(Long id);

    Optional<Video> findByPostId(Long id);
}