package com.trelobifteki.kaliarntokouto.services;

import com.trelobifteki.kaliarntokouto.Mocks;
import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.models.Keyword;
import com.trelobifteki.kaliarntokouto.repositories.KeywordRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KeywordServiceUnitTest {

    private final KeywordRepository repository = Mockito.mock(KeywordRepository.class);
    private final KeywordConverter converter = Mockito.mock(KeywordConverter.class);
    private final KeywordService service = new KeywordService(repository, converter);

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(repository, converter);
        reset(repository, converter);
    }

    @Test
    void getByKeywordReturnsNonEmptyKeywordField() {
        final String keyword = "test";
        final KeywordEntity expected = Mocks.createKeywordEntity(keyword);
        when(repository.findOneByKeyword(keyword)).thenReturn(Optional.of(expected));
        when(converter.convert(expected)).thenReturn(new Keyword(keyword));
        final Keyword result = service.getByKeyword(keyword);
        verify(repository).findOneByKeyword(keyword);
        verify(converter).convert(expected);
        assertThat(result).isNotNull();
        assertThat(result.getKeyword()).isEqualTo(keyword);
    }

    @Test
    void search() {
        final String keyword = "test";
        final KeywordEntity expected = Mocks.createKeywordEntity(keyword);
        when(repository.findByKeyword(keyword)).thenReturn(Stream.of(expected));
        when(converter.convert(expected)).thenReturn(new Keyword(keyword));
        final List<Keyword> results = service.search(keyword);
        verify(repository).findByKeyword(keyword);
        verify(converter).convert(expected);
        assertThat(results).hasSize(1);
    }
}