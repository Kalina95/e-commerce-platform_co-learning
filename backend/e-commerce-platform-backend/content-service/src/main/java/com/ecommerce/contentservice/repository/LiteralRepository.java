package com.ecommerce.contentservice.repository;

import com.ecommerce.contentservice.model.Literal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteralRepository extends JpaRepository<Literal, Integer> {
}
