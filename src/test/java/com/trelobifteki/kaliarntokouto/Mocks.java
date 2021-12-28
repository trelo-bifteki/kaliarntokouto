package com.trelobifteki.kaliarntokouto;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;

public class Mocks {

    private Mocks() {}

    public static KeywordEntity createKeywordEntity(final String keyword) {
        return new KeywordEntity(keyword);
    }
}
