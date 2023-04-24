package com.example.demo.Requests;

import java.util.Date;

public class EmpruntRequest {
	
	private Date dated;
	private Date datef;
	private long idLivre;
	private long idAdherant;
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
	public long getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}
	public long getIdAdherant() {
		return idAdherant;
	}
	public void setIdAdherant(long idAdherant) {
		this.idAdherant = idAdherant;
	}

}
