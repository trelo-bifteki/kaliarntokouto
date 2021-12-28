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
    private final KeywordService service = new KeywordService(repository);

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(repository);
        reset(repository);
    }

    @Test
    void getByKeywordReturnsNonEmptyKeywordField() {
        final String keyword = "test";
        final KeywordEntity expected = Mocks.createKeywordEntity(keyword);
        when(repository.findOneByKeyword(keyword)).thenReturn(Optional.of(expected));
        final Keyword result = service.getByKeyword(keyword);
        verify(repository).findOneByKeyword(keyword);
        assertThat(result).isNotNull();
        assertThat(result.getKeyword()).isEqualTo(keyword);
    }

    @Test
    void search() {
        final String keyword = "test";
        final KeywordEntity expected = Mocks.createKeywordEntity(keyword);
        when(repository.findByKeyword(keyword)).thenReturn(Stream.of(expected));
        final List<Keyword> results = service.search(keyword);
        verify(repository).findByKeyword(keyword);
        assertThat(results).hasSize(1);
    }
}