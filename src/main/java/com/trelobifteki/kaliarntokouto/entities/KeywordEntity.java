package com.trelobifteki.kaliarntokouto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

@Entity
@Table(name = "keyword")
@Getter
@Setter
@ToString
@Immutable
public class KeywordEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 250)
    private String keyword;

    @OneToMany(mappedBy = "keyword")
    private Set<TranslationEntity> translations;

    @Column(length = 2048)
    private String description;

    @CreatedDate
    private Timestamp created;

    @LastModifiedDate
    private Timestamp updated;

    protected KeywordEntity() {}

    public KeywordEntity(final String keyword, final Set<TranslationEntity> translations) {
        this.keyword = keyword;
        this.translations = unmodifiableSet(translations);
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
