package com.ecommerce.contentservice.configuration;

import com.ecommerce.contentservice.controller.ContentController;
import com.ecommerce.contentservice.controller.ImageController;
import com.ecommerce.contentservice.repository.ContentRepository;
import com.ecommerce.contentservice.repository.LiteralRepository;
import com.ecommerce.contentservice.service.ContentService;
import com.ecommerce.contentservice.service.ImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public ContentController contentController(ContentService service){
        return new ContentController(service);
    }

    @Bean
    public ContentService contentService(ContentRepository contentRepository, LiteralRepository literalRepository){
        return new ContentService(contentRepository, literalRepository);
    }
    @Bean
    public ImageService imageService(){
        return new ImageService();
    }

    @Bean
    public ImageController imageController(ImageService imageService){
        return new ImageController(imageService);
    }

}
