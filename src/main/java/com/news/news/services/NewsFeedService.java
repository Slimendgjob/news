package com.news.news.services;

import com.news.news.domain.News;
import com.news.news.domain.NewsStatus;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

public interface NewsFeedService {
    List<News> getByStatusAndPublicationDateBetween(
            @Nullable NewsStatus status,
            @Nullable OffsetDateTime publicationDateBegin,
            @Nullable OffsetDateTime publicationDateEnd
    );
}
