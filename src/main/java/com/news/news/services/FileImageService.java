package com.news.news.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileImageService {
    String uploadImageToDisk(MultipartFile multipartFile);
}
