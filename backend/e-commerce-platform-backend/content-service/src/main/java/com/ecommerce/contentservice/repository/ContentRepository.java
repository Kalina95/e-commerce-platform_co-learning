package com.ecommerce.contentservice.repository;

import com.ecommerce.contentservice.model.Literal;

import java.util.HashSet;
import java.util.Set;

public class ContentRepository {
    public Set<Literal> getLiterals(){return new HashSet<>();}
    public Set<Literal> getImages(){return new HashSet<>();}
    public Set<Literal> getIcons(){return new HashSet<>();}
}
