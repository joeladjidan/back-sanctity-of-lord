package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Galerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalerieRepository extends JpaRepository<Galerie, Integer> {
    Galerie findByDonneeId(Integer id);
}
