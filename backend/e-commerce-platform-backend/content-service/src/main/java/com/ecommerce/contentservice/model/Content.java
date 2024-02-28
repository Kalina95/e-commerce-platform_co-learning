package com.ecommerce.contentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CONTENT_TABLE")
public class Content implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CONTENT_ID")
    private int contentId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMPONENT")
    private Component component;

    @Column(name = "LITERALS")
    @OneToMany(mappedBy = "content")
    private Set<Literal> literals;

    @Column(name = "IMAGES")
    @OneToMany(mappedBy = "content")
    private Set<Image> images;

    @Column(name = "ICONS")
    @OneToMany(mappedBy = "content")
    private Set<Icon> icons;

}
