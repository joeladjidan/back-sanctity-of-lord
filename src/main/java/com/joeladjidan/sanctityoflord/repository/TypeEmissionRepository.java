package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.TypeEmission;
import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeEmissionRepository extends JpaRepository<TypeEmission, Integer> {
    Optional<TypeEmission> findByIntitule(String intitule);
}
