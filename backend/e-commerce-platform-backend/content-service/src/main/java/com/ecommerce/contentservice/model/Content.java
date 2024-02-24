package com.ecommerce.contentservice.model;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Content implements Serializable {
    private Component component;
    private Set<Literal> literals;
    private Set<Literal> images;
    private Set<Literal> icons;
}
