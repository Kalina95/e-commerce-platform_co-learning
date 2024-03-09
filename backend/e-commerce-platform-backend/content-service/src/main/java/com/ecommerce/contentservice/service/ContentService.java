package com.ecommerce.contentservice.service;

import com.ecommerce.contentservice.exception.ContentNotFoundException;
import com.ecommerce.contentservice.model.*;
import com.ecommerce.contentservice.repository.ContentRepository;
import com.ecommerce.contentservice.repository.IconRepository;
import com.ecommerce.contentservice.repository.ImageRepository;
import com.ecommerce.contentservice.repository.LiteralRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
public class ContentService {
    private final ContentRepository contentRepository;
    private final LiteralRepository literalRepository;
    private final IconRepository iconRepository;
    private final ImageRepository imageRepository;

    public int saveContent(Content contentToSave) {
        Content content = new Content();
        content.setContentId(0);
        content.setName(contentToSave.getName());
        content.setComponent(contentToSave.getComponent());
        Content savedContent = contentRepository.save(content);
        literalRepository.saveAll(prepareLiterals(contentToSave.getLiterals(), savedContent));
        iconRepository.saveAll(prepareIcons(contentToSave.getIcons(), savedContent));
        imageRepository.saveAll(prepareImages(contentToSave.getImages(), savedContent));
        log.info("Content with name: {} saved. Content id: {}", savedContent.getName(), savedContent.getContentId());
        return content.getContentId();
    }

    public Content getContentForComponent(String componentAsString) {
        Optional<Content> content = contentRepository.findLastContentByComponent(decodeComponent(componentAsString));
        if (content.isPresent()) {
            log.info("Found content with id: {}", content.get().getContentId());
            return content.get();
        } else {
            throw new ContentNotFoundException("Cannot find content for component: " + componentAsString);
        }
    }

    public Set<Literal> getLiteralsForComponent(String componentAsString) {
        Optional<Set<Literal>> literals = literalRepository.findLastLiteralsByComponent(decodeComponent(componentAsString));
        if (literals.isPresent() && !literals.get().isEmpty()) {
            log.info("Found {} literals", literals.get().size());
            return literals.get();
        } else {
            throw new ContentNotFoundException("Cannot find literals for component: " + componentAsString);
        }
    }

    public Set<Icon> getIconsForComponent(String componentAsString) {
        Optional<Set<Icon>> icons = iconRepository.findLastIconsByComponent(decodeComponent(componentAsString));
        if (icons.isPresent() && !icons.get().isEmpty()) {
            log.info("Found {} icons", icons.get().size());
            return icons.get();
        } else {
            throw new ContentNotFoundException("Cannot find icons for component: " + componentAsString);
        }
    }

    public Set<Image> getImagesForComponent(String componentAsString) {
        Optional<Set<Image>> images = imageRepository.findLastImagesByComponent(decodeComponent(componentAsString));
        if (images.isPresent() && !images.get().isEmpty()) {
            log.info("Found {} images", images.get().size());
            return images.get();
        } else {
            throw new ContentNotFoundException("Cannot find images for component: " + componentAsString);
        }
    }

    private Set<Icon> prepareIcons(Set<Icon> icons, Content content) {
        return icons.stream().map(iconToSave -> {
            Icon icon = new Icon();
            icon.setIconId(0);
            icon.setContent(content);
            icon.setComponent(content.getComponent());
            icon.setName(iconToSave.getName());
            return icon;
        }).collect(Collectors.toSet());

    }

    private Set<Image> prepareImages(Set<Image> images, Content content) {
        return images.stream().map(imageToSave -> {
            Image image = new Image();
            image.setImageId(0);
            image.setContent(content);
            image.setComponent(content.getComponent());
            image.setName(imageToSave.getName());
            image.setUrl(imageToSave.getUrl());
            return image;
        }).collect(Collectors.toSet());

    }

    private Set<Literal> prepareLiterals(Set<Literal> literals, Content content) {
        return literals.stream().map(literalToSave -> {
            Literal literal = new Literal();
            literal.setLiteralId(0);
            literal.setContent(content);
            literal.setComponent(content.getComponent());
            literal.setType(literalToSave.getType());
            literal.setValue(literalToSave.getValue());
            return literal;
        }).collect(Collectors.toSet());
    }

    private String decodeComponent(String componentAsString) {
        Component component = Component.getComponentByValue(componentAsString);
        return Component.getComponentValueAsStringInPascalNotation(component);
    }


}
