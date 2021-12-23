package com.trelobifteki.kaliarntokouto.services;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.models.Keyword;
import com.trelobifteki.kaliarntokouto.repositories.KeywordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KeywordService {

    private final KeywordRepository repository;

    public Keyword getByKeyword(final String keyword) {
        return repository.findOneByKeyword(keyword)
                .map(this::convert)
                .orElseThrow(() -> new IllegalArgumentException("not found dear"));
    }

    private Keyword convert(KeywordEntity source) {
        return new Keyword(source.getKeyword());
    }
}
