package com.ecommerce.contentservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Icon {
    private int id;
    private Component component;
    private String name;
}
