package com.trelobifteki.kaliarntokouto.entities;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "keyword")
@Getter
@ToString
public class KeywordEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String keyword;

    protected KeywordEntity() {}

    public KeywordEntity(final String keyword) {
        this.keyword = keyword;
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
