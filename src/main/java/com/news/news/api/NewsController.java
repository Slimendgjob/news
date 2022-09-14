package com.news.news.api;

import com.news.news.api.dto.NewsDto;
import com.news.news.api.dto.NewsUpdateResponse;
import com.news.news.api.validate.OnSave;
import com.news.news.domain.News;
import com.news.news.domain.NewsStatus;
import com.news.news.mapper.NewsMapper;
import com.news.news.services.NewsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {

    private final NewsServices newsServices;
    private final NewsMapper newsMapper;

    @GetMapping("/{id}")
    public News getById(@PathVariable Long id) {
        return newsServices.getById(id);
    }

    @PostMapping
    public Long save(@Validated(OnSave.class) @RequestBody NewsDto dto) {
        return newsServices.save(newsMapper.toDomain(dto)).getId();
    }

    @PutMapping
    public NewsUpdateResponse updateStatus(@RequestParam Long id, @RequestParam NewsStatus status) {
        News news = newsServices.getById(id);
        news.setStatus(status);
        news.setPublicationDate(OffsetDateTime.now());
        return newsMapper.toUpdateDto(newsServices.save(news));
    }
}
