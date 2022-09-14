package com.news.news.api.dto;

import com.news.news.domain.NewsStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class NewsFeedResponse {
    private String title;
    private String imageUri;
    private OffsetDateTime publicationDate;
    private NewsStatus status;
    private AuthorDto author;
}
