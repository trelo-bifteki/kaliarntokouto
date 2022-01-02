package com.trelobifteki.kaliarntokouto;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.entities.TranslationEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;

public class Mocks {

    public static final String DESCRIPTION = "This is a test";

    private Mocks() {}

    public static KeywordEntity createKeywordEntity(final String keyword, final String translation) {
        final KeywordEntity result = new KeywordEntity(keyword);
        final TranslationEntity translationEntity = new TranslationEntity(result, translation);
        result.setTranslations(Collections.singleton(translationEntity));
        result.setDescription(DESCRIPTION);
        result.setCreated(Timestamp.valueOf(LocalDateTime.MIN));
        return result;
    }

    public static KeywordEntity createKeywordEntity(final String keyword) {
        return createKeywordEntity(keyword, keyword);
    }

}
