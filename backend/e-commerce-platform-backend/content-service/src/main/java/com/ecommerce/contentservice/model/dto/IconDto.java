package com.ecommerce.contentservice.model.dto;

import com.ecommerce.contentservice.model.Icon;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IconDto {
    private String component;
    private String name;
    private String contentName;

    public IconDto(Icon icon) {
        this.component = icon.getComponent().getValue();
        this.contentName = icon.getContent().getName();
        this.name = icon.getName();
    }
}
