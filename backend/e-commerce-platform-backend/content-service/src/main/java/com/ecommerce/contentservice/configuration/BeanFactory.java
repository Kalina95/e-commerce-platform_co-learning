package com.ecommerce.contentservice.configuration;

import com.ecommerce.contentservice.controller.ContentController;
import com.ecommerce.contentservice.repository.ContentRepository;
import com.ecommerce.contentservice.service.ContentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public ContentController contentController(ContentService service){
        return new ContentController(service);
    }

    @Bean
    public ContentService contentService(ContentRepository repository){
        return new ContentService(repository);
    }

}
