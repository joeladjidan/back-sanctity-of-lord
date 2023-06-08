package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnseignementRepository extends JpaRepository<Enseignement, Integer> {
    Optional<Enseignement> findByTitreMessageIntituleAndTypeEnseignementIntitule(String titreMessage , String typeEnseignement);
    Enseignement findByDonneeId(Integer id);
}
