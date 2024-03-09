package com.ecommerce.contentservice.controller;

import com.ecommerce.contentservice.exception.ContentNotFoundException;
import com.ecommerce.contentservice.exception.EmptyComponentException;
import com.ecommerce.contentservice.exception.NoSuchComponentException;
import com.ecommerce.contentservice.model.Content;
import com.ecommerce.contentservice.model.Icon;
import com.ecommerce.contentservice.model.Image;
import com.ecommerce.contentservice.model.Literal;
import com.ecommerce.contentservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@ResponseBody
@RequiredArgsConstructor
@Slf4j
public class ContentController {
    private final ContentService service;

    @GetMapping(value = "/content/{component}")
    public ResponseEntity<Content> getContent(@PathVariable String component) {
        Content result = service.getContentForComponent(component);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/content/literals/{component}")
    public ResponseEntity<Set<Literal>> getLiterals(@PathVariable String component) {
        Set<Literal> literals = service.getLiteralsForComponent(component);
        return new ResponseEntity<>(literals, HttpStatus.OK);
    }

    @GetMapping(value = "/content/images/{component}")
    public ResponseEntity<Set<Image>> getImages(@PathVariable String component) {
        Set<Image> images = service.getImagesForComponent(component);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping(value = "/content/icons/{component}")
    public ResponseEntity<Set<Icon>> getIcons(@PathVariable String component) {
        Set<Icon> icons = service.getIconsForComponent(component);
        return new ResponseEntity<>(icons, HttpStatus.OK);
    }

    @PostMapping(value = "/content")
    public ResponseEntity<Integer> saveContent(@RequestBody Content content) {
        int result = service.saveContent(content);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(EmptyComponentException.class)
    public ResponseEntity<String> handleEmptyComponentException(EmptyComponentException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContentNotFoundException.class)
    public ResponseEntity<String> handleContentNotFoundException(ContentNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchComponentException.class)
    public ResponseEntity<String> handleEmptyComponentException(NoSuchComponentException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
