package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Optional<Ville> findByIntitule(String intitule);
}
