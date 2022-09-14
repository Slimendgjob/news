package com.news.news.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> getByStatusOrPublicationDateBetween(
            NewsStatus status,
            OffsetDateTime publicationDateBegin,
            OffsetDateTime publicationDateEnd
    );
}
