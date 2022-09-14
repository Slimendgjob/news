package com.news.news.services;

import com.news.news.domain.News;

public interface NewsServices {
    News save(News news);

    News getById(Long id);
}
