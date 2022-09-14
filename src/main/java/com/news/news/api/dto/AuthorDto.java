package com.news.news.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private String login;

    private String firstName;
    private String middleName;
    private String lastName;
}
