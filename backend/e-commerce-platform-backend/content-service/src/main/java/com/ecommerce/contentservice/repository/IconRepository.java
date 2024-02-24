package com.ecommerce.contentservice.repository;

import com.ecommerce.contentservice.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<Icon, Integer> {
}
