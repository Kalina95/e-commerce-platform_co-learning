package com.ecommerce.contentservice.controller;

import com.ecommerce.contentservice.model.Component;
import com.ecommerce.contentservice.model.Content;
import com.ecommerce.contentservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class ContentController {
    private final ContentService service;

    @GetMapping(value = "/content/{component}")
    public Content getContent(@PathVariable String component) {
        return service.getContentForComponent(Component.getComponentByValue(component));
    }

}
