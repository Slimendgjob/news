package com.news.news.api.dto;

import com.news.news.api.validate.OnSave;
import com.news.news.domain.NewsStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Null;

@Getter
@Setter
public class NewsDto {
    @Null(groups = OnSave.class)
    private Long id;

    private String title;
    private String content;
    private String imageUri;

    private NewsStatus status;

    private AuthorDto author;
}
