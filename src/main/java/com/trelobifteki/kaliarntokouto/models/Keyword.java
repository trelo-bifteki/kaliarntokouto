package com.trelobifteki.kaliarntokouto.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Keyword {

    private final String keyword;
    private final Set<String> translations;
    private final String description;


    public Keyword(String keyword, Set<String> translations) {
        this(keyword, translations, "");
    }

    public Keyword(String keyword) {
        this(keyword, Collections.emptySet());
    }
}
