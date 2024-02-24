package com.ecommerce.contentservice.model;

import lombok.Data;

@Data
public class Literal {
    private int id;
    private Component component;
    private String value;
    private String type;
}
