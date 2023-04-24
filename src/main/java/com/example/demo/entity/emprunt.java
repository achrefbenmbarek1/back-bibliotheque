package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class emprunt {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idlivre")
    private livre Livre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idadherant")
    private adherant Adherent;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dated;
	@Temporal(TemporalType.DATE)
	@Column
	private Date datef;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public livre getLivre() {
		return Livre;
	}
	public void setLivre(livre livre) {
		Livre = livre;
	}
	public adherant getAdherent() {
		return Adherent;
	}
	public void setAdherent(adherant adherent) {
		Adherent = adherent;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public Date getDatef() {
		return datef;
	}
	public void setDatef(Date datef) {
		this.datef = datef;
	}
	public emprunt(Integer id, livre livre, adherant adherent, Date dated, Date datef) {
		super();
		this.id = id;
		Livre = livre;
		Adherent = adherent;
		this.dated = dated;
		this.datef = datef;
	}
	public emprunt( livre livre, adherant adherent, Date dated, Date datef) {
		super();
		Livre = livre;
		Adherent = adherent;
		this.dated = dated;
		this.datef = datef;
	}
	public emprunt()
	{
		
	}
	
}
