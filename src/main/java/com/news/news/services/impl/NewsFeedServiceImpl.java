package com.news.news.services.impl;

import com.news.news.domain.News;
import com.news.news.domain.NewsRepository;
import com.news.news.domain.NewsStatus;
import com.news.news.services.NewsFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsFeedServiceImpl implements NewsFeedService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> getByStatusAndPublicationDateBetween(
            NewsStatus status,
            OffsetDateTime publicationDateBegin,
            OffsetDateTime publicationDateEnd
    ) {
        return newsRepository.getByStatusOrPublicationDateBetween(
                status, publicationDateBegin, publicationDateEnd
        );
    }
}
