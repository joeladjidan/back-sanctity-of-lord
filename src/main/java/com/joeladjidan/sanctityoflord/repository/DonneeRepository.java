package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.CodePostale;
import com.joeladjidan.sanctityoflord.model.Donnee;
import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonneeRepository extends JpaRepository<Donnee, Integer> {
    Optional<Donnee> findByFormatAndFileName(String format , String fileName);
}
