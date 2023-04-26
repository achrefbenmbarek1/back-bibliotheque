package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Exception.InvalidNameOrExtensionException;
import com.example.demo.Exception.ProblemWhenSavingBookCoverException;
import com.example.demo.entity.livre;
import com.example.demo.repository.LivreRepository;
import com.example.demo.valueObject.BookCover;

@Service("bookCoverService")
public class ImageDeCouvertureDeLivreService {
    public String saveCover(MultipartFile file) {
        String originalImageName = StringUtils.cleanPath(file.getOriginalFilename());
        BookCover bookCover = new BookCover(originalImageName);
        String generatedUniqueName = bookCover.generateImageName();
        Path path = Paths.get("src/main/resources/images/" + generatedUniqueName);
        try {
            Files.write(path, file.getBytes());
            return generatedUniqueName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ProblemWhenSavingBookCoverException("problem when saving the image");
        }

    }

    public void deleteCover(String imagePath) {
        Path wrappedImagePath = Paths.get("src/main/resources/images/" + imagePath);
        if (!Files.exists(wrappedImagePath)) {
            throw new InvalidNameOrExtensionException("bookCover not found");
        }
        try {
            Files.delete(wrappedImagePath);
        } catch (IOException e) {
            throw new ProblemWhenSavingBookCoverException("an unexpected error happened when deleting the image");
        }
    }
}
