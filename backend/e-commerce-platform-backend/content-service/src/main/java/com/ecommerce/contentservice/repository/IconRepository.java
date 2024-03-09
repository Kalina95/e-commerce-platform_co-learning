package com.ecommerce.contentservice.repository;

import com.ecommerce.contentservice.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IconRepository extends JpaRepository<Icon, Integer> {
    @Query(value = "SELECT * FROM icons ic INNER JOIN component c ON ic.component = c.component_id WHERE c.component_value = ?1 AND ic.content_id = (SELECT TOP 1 CONTENT_ID FROM content_table ct INNER JOIN component c ON ct.component = c.component_id WHERE c.component_value = ?1 ORDER BY ct.content_id DESC) ORDER BY ic.content_id DESC;", nativeQuery = true)
    Optional<Set<Icon>> findLastIconsByComponent(String componentName);

}
