package com.ecommerce.contentservice.model.dto;

import com.ecommerce.contentservice.model.Literal;

import java.io.Serializable;

public class LiteralDto implements Serializable {
    private String component;
    private String value;
    private String type;
    private String contentName;


    public LiteralDto(Literal literal) {
        this.component = literal.getComponent().getValue();
        this.value = literal.getValue();
        this.type = literal.getType();
        this.contentName = literal.getContent().getName();
    }

}
