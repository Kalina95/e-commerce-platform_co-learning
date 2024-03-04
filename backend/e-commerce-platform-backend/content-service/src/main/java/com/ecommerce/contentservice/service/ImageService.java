package com.ecommerce.contentservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageService {

    @Value("${assets-uri}")
    private String assetsUri;

    public Resource getImage(String imageName) throws IOException {
        Path path = Path.of(assetsUri + imageName);
        return new ByteArrayResource(Files.readAllBytes(path));
    }

}
