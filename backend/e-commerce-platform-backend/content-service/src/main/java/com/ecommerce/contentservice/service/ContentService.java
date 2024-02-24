package com.ecommerce.contentservice.service;

import com.ecommerce.contentservice.model.Component;
import com.ecommerce.contentservice.model.Content;
import com.ecommerce.contentservice.repository.ContentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository repository;

    public Content getContentForComponent(Component component){
        List<Content> contents = repository.findAll();
        return contents.stream()
                .filter(content -> content.getComponent().equals(component))
                .findFirst()
                .orElseThrow(()->new RuntimeException("no content for component: " + component.getValue()));
    }

    public Content putContent(Content content){
        content.setContentId(0);
        repository.save(content);
        return content;
    }
}
