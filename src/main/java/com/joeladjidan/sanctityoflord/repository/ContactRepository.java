package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
