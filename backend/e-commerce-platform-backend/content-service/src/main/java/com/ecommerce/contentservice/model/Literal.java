package com.ecommerce.contentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "LITERALS")
public class Literal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "LITERAL_ID")
    private int literalId;
    @Column(name = "COMPONENT")
    private Component component;
    @Column(name = "LITERAL_VALUE")
    private String value;
    @Column(name = "LITERAL_TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTENT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Content content;
}
