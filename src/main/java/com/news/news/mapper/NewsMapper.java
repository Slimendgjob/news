package com.news.news.mapper;

import com.news.news.api.dto.NewsDto;
import com.news.news.api.dto.NewsFeedResponse;
import com.news.news.api.dto.NewsUpdateResponse;
import com.news.news.domain.News;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface NewsMapper {
    News toDomain(NewsDto dto);

    NewsUpdateResponse toUpdateDto(News news);

    NewsFeedResponse toFeedDto(News news);

    List<NewsFeedResponse> toFeedDtoList(List<News> news);
}
