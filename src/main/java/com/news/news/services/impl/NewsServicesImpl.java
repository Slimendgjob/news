package com.news.news.services.impl;

import com.news.news.domain.News;
import com.news.news.domain.NewsRepository;
import com.news.news.exception.BaseException;
import com.news.news.services.NewsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsServicesImpl implements NewsServices {
    private final NewsRepository newsRepository;

    private final static String PATH = News.class.getSimpleName();

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    @Transactional(readOnly = true)
    public News getById(Long id) {
        Optional<News> news = newsRepository.findById(id);
        return news.orElseThrow(() -> BaseException.notFoundWithId(PATH, id));
    }
}
