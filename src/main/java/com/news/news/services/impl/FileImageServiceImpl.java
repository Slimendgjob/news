package com.news.news.services.impl;

import com.news.news.services.FileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileImageServiceImpl implements FileImageService {

    @Value("${upload.path}")
    private String imageUploadPath;

    @PostConstruct
    public void init() {
        try {
            Files.createDirectory(Paths.get(imageUploadPath));
        } catch (FileAlreadyExistsException ignored) {
        } catch (IOException ex) {
            throw new RuntimeException("Could not create new folder", ex);
        }
    }

    @Override
    public String uploadImageToDisk(MultipartFile multipartFile) {
        Objects.requireNonNull(multipartFile.getOriginalFilename());

        try {
            Path root = Paths.get(imageUploadPath).resolve(multipartFile.getOriginalFilename());
            Files.copy(multipartFile.getInputStream(), root);
            return root.toUri().toString();
        } catch (IOException ex) {
            throw new RuntimeException("Could save image", ex);
        }
    }
}
