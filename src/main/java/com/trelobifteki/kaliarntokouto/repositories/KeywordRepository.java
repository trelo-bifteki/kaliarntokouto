package com.trelobifteki.kaliarntokouto.repositories;

import com.trelobifteki.kaliarntokouto.entities.KeywordEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface KeywordRepository extends CrudRepository<KeywordEntity, Long> {
    Optional<KeywordEntity> findOneByKeyword(String keyword);

    Stream<KeywordEntity> findByKeyword(String keyword);
}
