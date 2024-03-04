package com.ecommerce.contentservice.repository;

import com.ecommerce.contentservice.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

    @Query(value = "SELECT TOP 1 * FROM content_table ct INNER JOIN component c ON ct.component = c.component_id WHERE c.component_value = ?1 ORDER BY ct.content_id DESC", nativeQuery = true)
    Content findLastContentByComponent(String componentName);
}
