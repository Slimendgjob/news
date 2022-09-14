package com.news.news.api.dto;

import com.news.news.domain.NewsStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class NewsUpdateResponse {
    private Long id;
    private NewsStatus status;
    private OffsetDateTime publicationDate;
}
