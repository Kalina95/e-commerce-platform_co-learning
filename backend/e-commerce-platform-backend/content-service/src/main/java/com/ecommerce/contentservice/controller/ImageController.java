package com.ecommerce.contentservice.controller;

import com.ecommerce.contentservice.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@ResponseBody
public class ImageController {

    private final ImageService service;

    @GetMapping(value = "/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        Resource result = service.getImage(imageName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
