package com.example.demo.service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.entity.livre;
import com.example.demo.repository.LivreRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service("bookService")
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public livre getLivreById(Long id) {
        return livreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    public void saveLivre(livre livre) {
        livreRepository.save(livre);
    }

    public String deleteLivre(Long id) {
        Optional<livre> wrappedBook = livreRepository.findById(id);
        if (!wrappedBook.isPresent()) {
            throw new NotFoundException("book couldn't be found");
        }
        livre livreInstance = wrappedBook.get();
        livreRepository.deleteById(id);
        return livreInstance.getImageDeCouverture();

    }
    public livre RendreLivre(Long id) {
        livre existingBook = livreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
            
            existingBook.setNbCopie(existingBook.getNbCopie()+1);
            return livreRepository.save(existingBook);
        }

    public livre updateBook(Long id, livre book) {
        livre existingBook = livreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        existingBook.setTitre(book.getTitre());
        existingBook.setAuteur(book.getAuteur());
        existingBook.setGenre(book.getGenre());
        existingBook.setLangue(book.getLangue());
        existingBook.setName(book.getName());
        existingBook.setPrix(book.getPrix());
        existingBook.setImageDeCouverture(book.getImageDeCouverture());
        existingBook.setNbCopie(book.getNbCopie());
        return livreRepository.save(existingBook);
    }

}
