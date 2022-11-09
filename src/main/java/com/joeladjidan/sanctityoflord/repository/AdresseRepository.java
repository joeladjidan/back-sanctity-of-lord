package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Adresse;
import com.joeladjidan.sanctityoflord.model.Artiste;
import com.joeladjidan.sanctityoflord.model.Donnee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
    Optional<Adresse> findByAdresse1(String adresse1);
}
