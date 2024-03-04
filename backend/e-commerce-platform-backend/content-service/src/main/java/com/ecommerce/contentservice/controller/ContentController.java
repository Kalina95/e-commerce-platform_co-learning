package com.ecommerce.contentservice.controller;

import com.ecommerce.contentservice.model.Component;
import com.ecommerce.contentservice.model.Content;
import com.ecommerce.contentservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class ContentController {
    private final ContentService service;

    @GetMapping(value = "/content/{component}")
    public ResponseEntity<Content> getContent(@PathVariable String component) {
        Content result = service.getContentForComponent(component);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/content")
    public ResponseEntity<Content> saveContent(@RequestBody Content content) {
        Content result = service.saveContent(content);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
