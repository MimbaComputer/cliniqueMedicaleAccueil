package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="typePersonne",discriminatorType=DiscriminatorType.INTEGER,length=1)
//@DiscriminatorValue("0")
public class Personne implements Serializable{
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=2,max=30)
	private String nom;
	@Size(min=2,max=30)
	private String prenom;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dateNaissance;
	@NotNull
	@Size(max=1)
	private String sexe;
	@Size(max=30)
	private String etatCivil;
	@Size(min=5,max=50)
	private String cni;
	@Size(min=6,max=50)
	private String telephone;
	@Size(min=6,max=50)
	private String specialite;
	@Size(min=2,max=50)
	@NotNull
	private String adresse;
	@Email
	@Size(min=2,max=50)
	private String email;
	@Lob
	private byte[] photo;
	@OneToOne(mappedBy="personne")
	private Patient patient;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String nom, Date dateNaissance, String sexe, String etatCivil, String telephone, String specialite,
			String adresse) {
		super();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.etatCivil = etatCivil;
		this.telephone = telephone;
		this.specialite = specialite;
		this.adresse = adresse;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getEtatCivil() {
		return etatCivil;
	}
	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
