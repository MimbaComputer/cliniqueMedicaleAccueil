package org.mimba.bao.dao;

import java.util.Date;

import org.mimba.bao.entities.Patient;
import org.mimba.bao.entities.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IPersonneRepository extends JpaRepository<Personne, Long> {

	public Page<Personne> findById(@Param("id") Long id, Pageable pageable);

	public Page<Personne> findByNom(@Param("nom") String nom, Pageable pageable);

	public Page<Personne> findByPrenom(@Param("prenom") String prenom, Pageable pageable);

	public Page<Personne> findByDateNaissance(@Param("dateNaissance") Date dateNaissance, Pageable pageable);

	public Page<Personne> findBySexe(@Param("sexe") String sexe, Pageable pageable);

	public Page<Personne> findByEtatCivil(@Param("etatCivil") String etatCivil, Pageable pageable);

	public Page<Personne> findByCni(@Param("cni") String cni, Pageable pageable);

	public Page<Personne> findByTelephone(@Param("telephone") String telephone, Pageable pageable);

	public Page<Personne> findBySpecialite(@Param("specialite") String specialite, Pageable pageable);

	public Page<Personne> findByAdresse(@Param("adresse") String adresse, Pageable pageable);

	public Page<Personne> findByEmail(@Param("email") String email, Pageable pageable);

	@Query("select p from Personne p where p.nom like:mc")
	public Page<Personne> nomPersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.prenom like:mc")
	public Page<Personne> prenomPersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.dateNaissance like:mc")
	public Page<Personne> dateNaissancePersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.sexe like:mc")
	public Page<Personne> sexePersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.etatCivil like:mc")
	public Page<Personne> etatCivilPersonneParMC(@Param("mc") String etatCivil, Pageable pageable);

	@Query("select p from Personne p where p.cni like:mc")
	public Page<Personne> cniPersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.telephone like:mc")
	public Page<Personne> telephonePersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.specialite like:mc")
	public Page<Personne> specialitePersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.adresse like:mc")
	public Page<Personne> adressePersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.email like:mc")
	public Page<Personne> emailPersonneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Personne p where p.patient.id=:id")
	public Page<Personne> patientPersonneParId(@Param("id") Long id, Pageable pageable);

}
