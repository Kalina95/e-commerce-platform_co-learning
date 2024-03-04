package com.ecommerce.contentservice.service;

import com.ecommerce.contentservice.model.Component;
import com.ecommerce.contentservice.model.Content;
import com.ecommerce.contentservice.repository.ContentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository repository;

    public Content getContentForComponent(String componentAsString) {
        Component component = Component.getComponentByValue(componentAsString);
        String componentNamePreparedForQuery = Component.getComponentValueAsStringInPascalNotation(component);
        return repository.findLastContentByComponent(componentNamePreparedForQuery);
    }

    public Content saveContent(Content content) {
        content.setContentId(0);
        repository.save(content);
        return content;
    }
}
