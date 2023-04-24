package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.emprunt;
@Repository
public interface EmpRepository extends JpaRepository<emprunt,Long> {

}
