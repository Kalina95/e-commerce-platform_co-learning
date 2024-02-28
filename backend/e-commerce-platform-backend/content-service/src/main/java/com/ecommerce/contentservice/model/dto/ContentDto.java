package com.ecommerce.contentservice.model.dto;

import com.ecommerce.contentservice.model.Content;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ContentDto {
    private String component;
    private String name;
    private List<LiteralDto> literals;
    private List<ImageDto> images;
    private List<IconDto> icons;

    ContentDto(Content content) {
        this.component = content.getComponent().getValue();
        this.name = content.getName();
        this.literals = content.getLiterals().stream().map(LiteralDto::new).toList();
        this.images = content.getImages().stream().map(ImageDto::new).toList();
        this.icons = content.getIcons().stream().map(IconDto::new).toList();
    }
}
