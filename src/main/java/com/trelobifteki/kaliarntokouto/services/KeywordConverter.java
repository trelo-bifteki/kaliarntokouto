package com.trelobifteki.kaliarntokouto.services;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.entities.TranslationEntity;
import com.trelobifteki.kaliarntokouto.models.Keyword;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class KeywordConverter implements Converter<KeywordEntity, Keyword> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    @NonNull
    public Keyword convert(final KeywordEntity source) {
        Set<String> translations = convertTranslations(source.getTranslations());
        return new Keyword(source.getKeyword(), translations);
    }

    private Set<String> convertTranslations(final Set<TranslationEntity> source) {
        return source.stream().map(TranslationEntity::getDescription).collect(Collectors.toSet());
    }
}
