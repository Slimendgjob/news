package com.news.news.api.dto;

import com.news.news.domain.NewsStatus;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

@Data
public class NewsFeedRequest {
    @Nullable
    private NewsStatus newsStatus;
    @Nullable
    private OffsetDateTime publicationDateBegin;
    @Nullable
    private OffsetDateTime publicationDateEnd;
}
