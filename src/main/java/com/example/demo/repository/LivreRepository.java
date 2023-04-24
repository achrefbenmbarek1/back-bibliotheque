package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.livre;

@Repository
public interface LivreRepository extends JpaRepository<livre,Long> {
	

}

