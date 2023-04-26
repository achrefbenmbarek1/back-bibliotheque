package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Requests.EmpruntRequest;
import com.example.demo.entity.adherant;
import com.example.demo.entity.emprunt;
import com.example.demo.entity.livre;
import com.example.demo.repository.AdherantRepository;
import com.example.demo.repository.EmpRepository;
import com.example.demo.repository.LivreRepository;

@Service
public class EmpService {
	
	@Autowired
    private EmpRepository empRepository;
	@Autowired
	private AdherantRepository adherant_Rep ;
	@Autowired
	private LivreRepository livreRepository;
	
	public List<emprunt> getAllEmprunts() {
        return empRepository.findAll();
    }
    
    public emprunt getEmpruntById(Long id) {
        return empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }
    
    // public void saveEmprunt(EmpruntRequest request) {
    // 	  livre existingBook = livreRepository.findById(request.getIdLivre())
    // 	            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    // 	  adherant existingAdherant = adherant_Rep.findById(request.getIdAdherant())
  	 //            .orElseThrow(() -> new ResourceNotFoundException("Adherant not found"));
    // 	  emprunt Emprunt = new emprunt();
    // 	  Emprunt.setAdherent(existingAdherant);
    // 	  Emprunt.setLivre(existingBook);
    // 	  Emprunt.setDated(request.getDated());
    // 	  Emprunt.setDatef(request.getDatef());
    // 	empRepository.save(Emprunt);
    // }
     public void saveEmprunt(EmpruntRequest request) {
    	  livre existingBook = livreRepository.findById(request.getIdLivre())
    	            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    	  if(existingBook.getNbCopie()>0)
    	  {
    	  adherant existingAdherant = adherant_Rep.findById(request.getIdAdherant())
  	            .orElseThrow(() -> new ResourceNotFoundException("Adherant not found"));
    	  emprunt Emprunt = new emprunt();
    	  Emprunt.setAdherent(existingAdherant);
    	  Emprunt.setLivre(existingBook);
    	  Emprunt.setDated(request.getDated());
    	  Emprunt.setDatef(request.getDatef());
    	emprunt emprunt = empRepository.save(Emprunt);
    	if(emprunt!= null) {
          	existingBook.setNbCopie(existingBook.getNbCopie()-1);
          	livreRepository.save(existingBook);}
    	  }
    	  else
    	  {
    		  throw new ResourceNotFoundException("Livre non disponible !");
    	  }
    }
   
    public void deleteEmprunt(Long id) {
    	empRepository.deleteById(id);
    }

}
