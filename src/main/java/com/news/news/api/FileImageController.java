package com.news.news.api;

import com.news.news.services.FileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file/image")
public class FileImageController {

    private final FileImageService fileImageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImageToDisk(@RequestPart MultipartFile multipartFile) {
        return fileImageService.uploadImageToDisk(multipartFile);
    }
}
