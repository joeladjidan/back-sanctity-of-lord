package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Galerie;
import com.joeladjidan.sanctityoflord.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GalerieRepository extends JpaRepository<Galerie, Integer> {

}
