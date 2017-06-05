package org.mimba.bao.dao;

import org.mimba.bao.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IContactRepository extends JpaRepository<Contact, Long> {

	public Page<Contact> findById(@Param("id") Long id, Pageable pageable);

	public Page<Contact> findByProprietaire(@Param("proprietaire") String proprietaire, Pageable pageable);

	@Query("select c from Contact c where c.proprietaire like:mc")
	public Page<Contact> contactProprietaireParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from Contact c where c.email like:mc")
	public Page<Contact> contactEmailParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from Contact c where c.telephone like:mc")
	public Page<Contact> contactTelephoneParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from Contact c where c.adresse like:mc")
	public Page<Contact> contactAdresseParMC(@Param("mc") String mc, Pageable pageable);
}
