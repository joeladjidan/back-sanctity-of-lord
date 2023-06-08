package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Annonce, Integer> {

}
