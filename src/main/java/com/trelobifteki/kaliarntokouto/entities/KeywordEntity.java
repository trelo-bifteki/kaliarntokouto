package com.trelobifteki.kaliarntokouto.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "keyword")
@Getter
@Setter
@ToString
public class KeywordEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String keyword;

    @OneToMany
    private Set<TranslationEntity> translations;

    protected KeywordEntity() {}

    public KeywordEntity(final String keyword, final Set<TranslationEntity> translations) {
        this.keyword = keyword;
        this.translations = Collections.unmodifiableSet(translations);
    }

    public KeywordEntity(final String keyword) {
        this(keyword, Collections.emptySet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeywordEntity that = (KeywordEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, keyword);
    }
}
