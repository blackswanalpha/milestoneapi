package com.milestone.api.image;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milestone.api.image.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}
