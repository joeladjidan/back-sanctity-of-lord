package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Pays;
import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import com.joeladjidan.sanctityoflord.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaysRepository extends JpaRepository<Pays, Integer> {
    Optional<Pays> findByIntitule(String intitule);
}
