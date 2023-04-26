package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.livre;
import com.example.demo.service.ImageDeCouvertureDeLivreService;
import com.example.demo.service.LivreService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class LivreController {
    @Autowired
    @Qualifier("bookService")
    private LivreService bookService;

    @Autowired
    @Qualifier("bookCoverService")
    private ImageDeCouvertureDeLivreService bookCoverService;

    @GetMapping
    public List<livre> getAllBooks() {
        return bookService.getAllLivres();
    }

    @GetMapping("/{id}")
    public livre getBookById(@PathVariable Long id) {
        return bookService.getLivreById(id);
    }
    @PutMapping("/rendreLivre/{id}")
    public livre rendreLivre(@PathVariable Long id) {
        return bookService.RendreLivre(id);
    }

    @PostMapping
    public void createBook(@RequestBody livre book) {
        bookService.saveLivre(book);
    }

    @PutMapping("/{id}")
    public livre updateBook(@PathVariable Long id, @RequestBody livre book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        String bookCoverPath = bookService.deleteLivre(id);
        bookCoverService.deleteCover(bookCoverPath);

    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            String generateImageName = bookCoverService.saveCover(file);
            return ResponseEntity.ok(generateImageName);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());

        }

    }

    @DeleteMapping("/unupload/{imagePath}")
    public ResponseEntity<String> handleImageUnupload(@PathVariable String imagePath) {
        try {
            System.out.println("behi ena dkhalit");
            bookCoverService.deleteCover(imagePath);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
