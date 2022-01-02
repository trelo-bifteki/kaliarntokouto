package com.trelobifteki.kaliarntokouto.services;

import com.trelobifteki.kaliarntokouto.Mocks;
import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.models.Keyword;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KeywordConverterUnitTest {

    private final KeywordConverter converter = new KeywordConverter();

    @Test
    void testConvertReturnsNonNullKeyword() {
        final KeywordEntity keyword = Mocks.createKeywordEntity("test", "result");
        final Keyword result = converter.convert(keyword);
        assertThat(result.getKeyword()).isEqualTo("test");
    }

    @Test
    void testConvertReturnsNonEmptyTranslation() {
        final KeywordEntity keyword = Mocks.createKeywordEntity("test");
        final Keyword result = converter.convert(keyword);
        assertThat(result.getTranslations()).isNotEmpty();
    }

    @Test
    void testConvertReturnsDescriptionNonNull() {
        final KeywordEntity source = Mocks.createKeywordEntity("test");
        final Keyword target = converter.convert(source);
        assertThat(target.getDescription()).isEqualTo(Mocks.DESCRIPTION);
    }
}