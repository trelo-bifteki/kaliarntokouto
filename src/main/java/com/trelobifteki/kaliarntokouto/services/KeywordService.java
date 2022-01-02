package com.trelobifteki.kaliarntokouto.services;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import com.trelobifteki.kaliarntokouto.exceptions.KeywordNotFoundException;
import com.trelobifteki.kaliarntokouto.models.Keyword;
import com.trelobifteki.kaliarntokouto.repositories.KeywordRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class KeywordService {

    private final KeywordRepository repository;
    private final KeywordConverter converter;

    @Transactional(readOnly = true)
    public Keyword getByKeyword(final String keyword) {
        log.info("Get keyword: {}", keyword);
        return repository.findOneByKeyword(keyword)
                .map(converter::convert)
                .orElseThrow(() -> new KeywordNotFoundException(keyword));
    }

    @Transactional(readOnly = true)
    public List<Keyword> search(final String keyword) {
        log.info("search keyword: {}", keyword);
        return repository.findByKeyword(keyword)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


}
