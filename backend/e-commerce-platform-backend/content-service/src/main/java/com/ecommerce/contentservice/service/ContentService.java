package com.ecommerce.contentservice.service;

import com.ecommerce.contentservice.model.Component;
import com.ecommerce.contentservice.model.Content;
import com.ecommerce.contentservice.repository.ContentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository repository;

    public Content getContentForComponent(Component component){
        return Content.builder()
                .literals(repository.getLiterals())
                .images(repository.getImages())
                .icons(repository.getIcons())
                .component(component)
                .build();
    }
}
