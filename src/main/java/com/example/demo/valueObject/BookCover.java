package com.example.demo.valueObject;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.Exception.InvalidNameOrExtensionException;

public record BookCover(String imageNameWithExtension) implements Serializable {

    public BookCover {

        Pattern pattern = Pattern
                .compile("^(\\d{4}-\\d{2}-\\d{2}T\\d{2}-\\d{2}-\\d{2}\\.\\d{3}Z)?[a-zA-Z0-9_-]+\\.(png|jpg)$");
        Matcher matcher = pattern.matcher(imageNameWithExtension);
        if (!matcher.find())
            throw new InvalidNameOrExtensionException("invalid imageName or extension");
    }

    public String generateImageName() {
        Instant now = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss.SSS'Z'")
                .withZone(ZoneOffset.UTC);
        String formattedDateTime = formatter.format(now);
        String generatedImageName = formattedDateTime + imageNameWithExtension;
        Pattern pattern = Pattern
                .compile("^(\\d{4}-\\d{2}-\\d{2}T\\d{2}-\\d{2}-\\d{2}\\.\\d{3}Z)?[a-zA-Z0-9_-]+\\.(png|jpg)$");
        Matcher matcher = pattern.matcher(generatedImageName);
        if (!matcher.find())
            throw new InvalidNameOrExtensionException("java has betrayed me");
        return generatedImageName;

    }

    public boolean doesBookCoverExistInTheFileSystem() {
        Path bookCoverFile = Paths.get("/home/achref/Document/tps/tpSpringBoot/my-spring-boot-app/src/main/resources/images/" + imageNameWithExtension);

        try {
            return Files.exists(bookCoverFile);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

