package com.news.news.api;

import com.news.news.api.dto.NewsFeedRequest;
import com.news.news.api.dto.NewsFeedResponse;
import com.news.news.mapper.NewsMapper;
import com.news.news.services.NewsFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feed")
public class NewsFeedController {

    private final NewsFeedService newsFeedService;
    private final NewsMapper newsMapper;

    @PostMapping("/query")
    public List<NewsFeedResponse> getFeedByQuery(@RequestBody NewsFeedRequest request) {
        return newsMapper.toFeedDtoList(
                newsFeedService.getByStatusAndPublicationDateBetween(
                        request.getNewsStatus(),
                        request.getPublicationDateBegin(),
                        request.getPublicationDateEnd()
                )
        );
    }
}
