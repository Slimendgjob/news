package com.news.news.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String imageUri;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NewsStatus status;

    private OffsetDateTime publicationDate;
}
