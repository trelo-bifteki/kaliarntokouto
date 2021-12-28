package com.trelobifteki.kaliarntokouto.services;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.exceptions.KeywordNotFoundException;
import com.trelobifteki.kaliarntokouto.models.Keyword;
import com.trelobifteki.kaliarntokouto.repositories.KeywordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KeywordService {

    private final KeywordRepository repository;

    @Transactional(readOnly = true)
    public Keyword getByKeyword(final String keyword) {
        return repository.findOneByKeyword(keyword)
                .map(this::convert)
                .orElseThrow(() -> new KeywordNotFoundException(keyword));
    }

    @Transactional(readOnly = true)
    public List<Keyword> search(final String keyword) {
        return repository.findByKeyword(keyword)
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private Keyword convert(KeywordEntity source) {
        return new Keyword(source.getKeyword());
    }
}
