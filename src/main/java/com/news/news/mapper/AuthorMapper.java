package com.news.news.mapper;

import com.news.news.api.dto.AuthorDto;
import com.news.news.domain.Author;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toDomain(AuthorDto dto);
}
