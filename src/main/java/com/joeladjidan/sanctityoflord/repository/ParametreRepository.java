package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Archivre;
import com.joeladjidan.sanctityoflord.model.Parametre;
import com.joeladjidan.sanctityoflord.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
    Optional<Parametre> findByChemin(String chemin);
}
