package com.ecommerce.contentservice.model.dto;

import com.ecommerce.contentservice.model.Image;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImageDto {
    private String component;
    private String url;
    private String name;
    private String contentName;

    public ImageDto(Image image) {
        this.component = image.getComponent().getValue();
        this.url = image.getUrl();
        this.name = image.getName();
        this.contentName = image.getContent().getName();
    }
}
