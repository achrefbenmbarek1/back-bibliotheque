package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.adherant;
import com.example.demo.service.AdherantService;

@RestController
@RequestMapping("/Adherents")
@CrossOrigin(origins = "http://localhost:3000")
public class AdherantController {

	@Autowired
    private AdherantService adherantService;

    @GetMapping
    public List<adherant> getAllAdherants() {
        return adherantService.getAllAdherants();
    }

    @GetMapping("/{id}")
    public adherant getAdherantById(@PathVariable Long id) {
        return adherantService.getAdherantById(id);
    }

    @PostMapping
    public void createAdhherant(@RequestBody adherant Adherant) {
    	adherantService.saveAdherant(Adherant);
    }

    @PutMapping("/{id}")
    public adherant updateAdherant(@PathVariable Long id, @RequestBody adherant Adherant) {
        return adherantService.updateAdherant(id, Adherant);
    }

    @DeleteMapping("/{id}")
    public void deleteAdherant(@PathVariable Long id) {
    	adherantService.deleteAdherant(id);
    }
}

