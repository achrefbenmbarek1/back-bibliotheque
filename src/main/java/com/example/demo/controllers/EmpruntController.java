package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Requests.EmpruntRequest;
import com.example.demo.entity.emprunt;
import com.example.demo.entity.livre;
import com.example.demo.service.EmpService;
import com.example.demo.service.LivreService;

@RestController
@RequestMapping("/Emprunts")
public class EmpruntController {
	
	@Autowired
    private EmpService empService;

    @GetMapping
    public List<emprunt> getAllEmprunts() {
        return empService.getAllEmprunts();
    }

    @GetMapping("/{id}")
    public emprunt getEmpruntById(@PathVariable Long id) {
        return empService.getEmpruntById(id);
    }

    @PostMapping
    public void createEmprunt(@RequestBody EmpruntRequest request) {
    	empService.saveEmprunt(request);
    }

   
    @DeleteMapping("/{id}")
    public void deleteEmprunt(@PathVariable Long id) {
    	empService.deleteEmprunt(id);
    }
}

