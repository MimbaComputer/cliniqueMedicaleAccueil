package org.mimba.bao.dao;

import org.mimba.bao.entities.Patient;
import org.mimba.bao.entities.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface IPatientRepository extends JpaRepository<Patient, Long> {

	public Page<Patient> findById(@Param("id") Long id, Pageable pageable);

	public Page<Patient> findByAssurance(@Param("assurance") String assurance, Pageable pageable);

	public Page<Patient> findByRemarques(@Param("remarques") String remarques, Pageable pageable);

	public Page<Patient> findByParticulier(@Param("particulier") boolean particulier, Pageable pageable);

	public Page<Patient> findByCasUrgent(@Param("casUrgent") boolean casUrgent, Pageable pageable);

	@Query("select p from Patient p where p.assurance like:mc")
	public Page<Patient> assurancePatientParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Patient p where p.remarques like:mc")
	public Page<Patient> remarquesPatientParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select p from Patient p where p.personne.id=:idPersonne")
	public Page<Patient> personnePatientParId(@Param("idPersonne") Long idPersonne, Pageable pageable);

}
