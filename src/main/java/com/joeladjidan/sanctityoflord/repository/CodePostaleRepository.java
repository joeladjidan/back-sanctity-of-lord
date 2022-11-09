package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.CodePostale;
import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodePostaleRepository extends JpaRepository<CodePostale, Integer> {
    Optional<CodePostale> findByCode(String code);
}
