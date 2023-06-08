package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeEnseignementRepository extends JpaRepository<TypeEnseignement, Integer> {
    Optional<TypeEnseignement> findByIntitule(String intitule);

}
