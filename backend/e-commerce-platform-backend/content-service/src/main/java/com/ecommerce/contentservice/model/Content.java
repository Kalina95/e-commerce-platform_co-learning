package com.ecommerce.contentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Content implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTENT_ID")
    private int contentId;

    @Column(name = "COMPONENT")
    private Component component;

    @Column(name = "LITERALS")
    @OneToMany(mappedBy="content")
    private Set<Literal> literals;

    @Column(name = "IMAGES")
    @OneToMany(mappedBy="content")
    private Set<Literal> images;

    @Column(name = "ICONS")
    @OneToMany(mappedBy="content")
    private Set<Literal> icons;

}
