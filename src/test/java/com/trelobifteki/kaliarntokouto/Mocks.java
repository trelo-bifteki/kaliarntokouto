package com.trelobifteki.kaliarntokouto;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.entities.TranslationEntity;

import java.util.Collections;

public class Mocks {

    private Mocks() {}

    public static KeywordEntity createKeywordEntity(final String keyword, final String translation) {
        final KeywordEntity result = new KeywordEntity(keyword);
        final TranslationEntity translationEntity = new TranslationEntity(result, translation);
        result.setTranslations(Collections.singleton(translationEntity));
        return result;
    }

    public static KeywordEntity createKeywordEntity(final String keyword) {
        return createKeywordEntity(keyword, keyword);
    }

}
