package com.trelobifteki.kaliarntokouto.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "translation")
@Getter
public class TranslationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="keyword_id", nullable = false)
    private KeywordEntity keyword;

    private String description;

    protected TranslationEntity() {}

    public TranslationEntity(KeywordEntity keyword, String description) {
        this.keyword = keyword;
        this.description = description;
    }

}
