package org.mimba.bao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Contact implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 50)
	private String proprietaire;
	@NotNull
	@Size(min = 5, max = 50)
	private String adresse;
	@Email
	private String email;
	@NotNull
	@Size(min = 6, max = 50)
	private String telephone;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String proprietaire, String adresse, String email, String telephone) {
		super();
		this.proprietaire = proprietaire;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
