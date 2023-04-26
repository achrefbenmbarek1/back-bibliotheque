package com.example.demo.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class adherant {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer idadherant;
	
	@Column	
	private String nom;
	@Column 
	private String prenom;
	@Column
	private String addr;
	@Temporal(TemporalType.DATE)
	@Column
	private Date datenaiss;
	@Column
	private String cin;
	
	@OneToMany(mappedBy = "Adherent", cascade = CascadeType.ALL)
    private List<emprunt> emprunts;
	
	public Integer getIdadherant() {
		return idadherant;
	}
	public void setIdadherant(Integer idadherant) {
		this.idadherant = idadherant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public adherant(Integer idadherant, String nom, String prenom, String addr, Date datenaiss, String cin) {
		super();
		this.idadherant = idadherant;
		this.nom = nom;
		this.prenom = prenom;
		this.addr = addr;
		this.datenaiss = datenaiss;
		this.cin = cin;
	}
	public adherant( String nom, String prenom, String addr, Date datenaiss, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addr = addr;
		this.datenaiss = datenaiss;
		this.cin = cin;
	}
	public adherant()
	{
		
	}
	
	

}
