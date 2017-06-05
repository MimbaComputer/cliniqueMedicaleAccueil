package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
// @DiscriminatorValue("1")
public class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 30)
	private String assurance;
	@Size(min = 3, max = 50)
	private String remarques;
	@NotNull
	private boolean particulier;
	@NotNull
	private boolean casUrgent;
	@Size(min = 10, max = 50)
	private String personneAContacter;
	@NotNull
	@OneToOne
	private Personne personne;
	@OneToMany(mappedBy = "patient")
	private Collection<Imagerie> imagerie;
	@OneToMany(mappedBy = "patient")
	private Collection<CasASuivre> casASuivre;
	@OneToMany(mappedBy = "patient")
	private Collection<ConstanteMedicale> constanteMedicale;
	@OneToMany(mappedBy = "patient")
	private Collection<Visite> visite;
	@OneToMany(mappedBy = "patient")
	private Collection<Ordonnance> ordonnance;
	@OneToMany(mappedBy = "patient")
	private Collection<Antecedent> antecedent;
	@OneToMany(mappedBy = "patient")
	private Collection<Hospitalisation> hospitalisation;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String assurance, String remarques, boolean particulier, boolean casUrgent,
			String personneAContacter, Personne personne) {
		super();
		this.assurance = assurance;
		this.remarques = remarques;
		this.particulier = particulier;
		this.casUrgent = casUrgent;
		this.personneAContacter = personneAContacter;
		this.personne = personne;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssurance() {
		return assurance;
	}
	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}
	public String getRemarques() {
		return remarques;
	}
	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
	public boolean isParticulier() {
		return particulier;
	}
	public void setParticulier(boolean particulier) {
		this.particulier = particulier;
	}
	public boolean isCasUrgent() {
		return casUrgent;
	}
	public void setCasUrgent(boolean casUrgent) {
		this.casUrgent = casUrgent;
	}
	public String getPersonneAContacter() {
		return personneAContacter;
	}
	public void setPersonneAContacter(String personneAContacter) {
		this.personneAContacter = personneAContacter;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Collection<Imagerie> getImagerie() {
		return imagerie;
	}
	public void setImagerie(Collection<Imagerie> imagerie) {
		this.imagerie = imagerie;
	}
	public Collection<CasASuivre> getCasASuivre() {
		return casASuivre;
	}
	public void setCasASuivre(Collection<CasASuivre> casASuivre) {
		this.casASuivre = casASuivre;
	}
	public Collection<ConstanteMedicale> getConstanteMedicale() {
		return constanteMedicale;
	}
	public void setConstanteMedicale(Collection<ConstanteMedicale> constanteMedicale) {
		this.constanteMedicale = constanteMedicale;
	}
	public Collection<Visite> getVisite() {
		return visite;
	}
	public void setVisite(Collection<Visite> visite) {
		this.visite = visite;
	}
	public Collection<Ordonnance> getOrdonnance() {
		return ordonnance;
	}
	public void setOrdonnance(Collection<Ordonnance> ordonnance) {
		this.ordonnance = ordonnance;
	}
	public Collection<Antecedent> getAntecedent() {
		return antecedent;
	}
	public void setAntecedent(Collection<Antecedent> antecedent) {
		this.antecedent = antecedent;
	}
	public Collection<Hospitalisation> getHospitalisation() {
		return hospitalisation;
	}
	public void setHospitalisation(Collection<Hospitalisation> hospitalisation) {
		this.hospitalisation = hospitalisation;
	}

}

@Entity
class Imagerie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idCasASuivre")
	private CasASuivre casASuivre;
}

@Entity
class CasASuivre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
	@OneToMany(mappedBy="casASuivre")
	private Collection<Imagerie> imagerie;
}

@Entity
class ConstanteMedicale implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
}

@Entity
class Visite implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
}

@Entity
class Ordonnance implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
}

@Entity
class Antecedent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
}

@Entity
class Hospitalisation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
}