package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.adherant;
import com.example.demo.entity.livre;
import com.example.demo.repository.AdherantRepository;

@Service
public class AdherantService {
	@Autowired
    private  AdherantRepository adherant_Rep ;
	
	public List<adherant> getAllAdherants() {
        return adherant_Rep.findAll();
    }
    
    public adherant getAdherantById(Long id) {
        return adherant_Rep.findById(id).orElse(null);
    }
    
    public void saveAdherant(adherant adherant) {
    	adherant_Rep.save(adherant);
    }
    
    public void deleteAdherant(Long id) {
    	adherant_Rep.deleteById(id);
    }
    
    public adherant updateAdherant(Long id, adherant Adherant) {
    	adherant existingAdherent = adherant_Rep.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Adherant not found"));
    	existingAdherent.setNom(Adherant.getNom());
    	existingAdherent.setPrenom(Adherant.getPrenom());
    	existingAdherent.setCin(Adherant.getCin());
    	existingAdherent.setDatenaiss(Adherant.getDatenaiss());
    	existingAdherent.setAddr(Adherant.getAddr());
        return adherant_Rep.save(existingAdherent);
    }

}
