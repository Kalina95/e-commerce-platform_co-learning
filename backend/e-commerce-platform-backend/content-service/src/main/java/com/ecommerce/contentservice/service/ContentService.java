package com.ecommerce.contentservice.service;

import com.ecommerce.contentservice.exception.ContentNotFoundException;
import com.ecommerce.contentservice.model.*;
import com.ecommerce.contentservice.repository.ContentRepository;
import com.ecommerce.contentservice.repository.IconRepository;
import com.ecommerce.contentservice.repository.ImageRepository;
import com.ecommerce.contentservice.repository.LiteralRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;
//    private final IconRepository iconRepository;
//    private final ImageRepository imageRepository;
    private final LiteralRepository literalRepository;

    public Content getContentForComponent(String componentAsString) {
        Component component = Component.getComponentByValue(componentAsString);
        String componentNamePreparedForQuery = Component.getComponentValueAsStringInPascalNotation(component);
        Optional<Content> content = contentRepository.findLastContentByComponent(componentNamePreparedForQuery);
        if(content.isPresent()){
            return  content.get();
        } else {
            throw new ContentNotFoundException("Cannot find content for component: " + componentAsString);
        }
    }

    public Content saveContent(Content contentToSave) {
        Content content = new Content();
        content.setContentId(0);
        content.setName(contentToSave.getName());
        content.setComponent(contentToSave.getComponent());
        Content savedContent = contentRepository.save(content);
        literalRepository.save(prepareLiteral(contentToSave.getLiterals().stream().findFirst().get(), savedContent));
        return content;
    }

    private Icon prepareIcon(Icon iconToSave, Content content){
        Icon icon = new Icon();
        icon.setIconId(0);
        icon.setContent(content);
        icon.setComponent(content.getComponent());
        icon.setName(iconToSave.getName());
        return icon;
    }

    private Image prepareImage(Image imageToSave, Content content){
        Image image = new Image();
        image.setImageId(0);
        image.setContent(content);
        image.setComponent(content.getComponent());
        image.setName(imageToSave.getName());
        return image;
    }
    private Literal prepareLiteral(Literal literalToSave, Content content){
        Literal literal = new Literal();
        literal.setLiteralId(0);
        literal.setContent(content);
        literal.setComponent(content.getComponent());
        literal.setValue(literalToSave.getValue());
        literal.setType(literalToSave.getType());
        return literal;
    }


}
