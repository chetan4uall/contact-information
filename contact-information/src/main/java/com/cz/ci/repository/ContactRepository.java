package com.cz.ci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cz.ci.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	
	
}
