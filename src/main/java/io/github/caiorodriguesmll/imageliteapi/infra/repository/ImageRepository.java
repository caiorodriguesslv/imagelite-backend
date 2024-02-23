package io.github.caiorodriguesmll.imageliteapi.infra.repository;

import io.github.caiorodriguesmll.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
