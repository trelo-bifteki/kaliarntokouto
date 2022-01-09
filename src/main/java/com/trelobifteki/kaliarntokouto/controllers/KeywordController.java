package com.trelobifteki.kaliarntokouto.controllers;

import com.trelobifteki.kaliarntokouto.models.Keyword;
import com.trelobifteki.kaliarntokouto.services.KeywordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class KeywordController {

    private final KeywordService keywordService;

    @GetMapping(path = "/api/keywords/{keyword}")
    public Keyword get(@PathVariable String keyword) {
        return keywordService.getByKeyword(keyword);
    }

    @GetMapping(path = "/api/keywords")
    public List<Keyword> search(@RequestParam("keyword") String keyword) {
        return keywordService.search(keyword);
    }

    @GetMapping(path = "/api/dictionary")
    public Page<Keyword> listAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "20") final int pageSize
    ) {
        return keywordService.listAll(page, pageSize);
    }

}
