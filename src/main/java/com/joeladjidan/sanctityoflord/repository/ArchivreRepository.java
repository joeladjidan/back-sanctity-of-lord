package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Archivre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArchivreRepository extends JpaRepository<Archivre, Integer> {
    Optional<Archivre> findByMoisIntituleAndAnneeIntitule(String mois, String annee);
}
