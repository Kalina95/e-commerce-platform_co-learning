package com.ecommerce.contentservice.model;

import lombok.Data;

@Data
public class Image {
    private int id;
    private Component component;
    private String url;
    private String name;
}
