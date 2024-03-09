package com.ecommerce.contentservice.repository;

import com.ecommerce.contentservice.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query(value = "SELECT * FROM images im INNER JOIN component c ON im.component = c.component_id WHERE c.component_value = ?1 AND im.content_id = (SELECT TOP 1 CONTENT_ID FROM content_table ct INNER JOIN component c ON ct.component = c.component_id WHERE c.component_value = ?1 ORDER BY ct.content_id DESC) ORDER BY im.content_id DESC;", nativeQuery = true)
    Optional<Set<Image>> findLastImagesByComponent(String componentName);

}
