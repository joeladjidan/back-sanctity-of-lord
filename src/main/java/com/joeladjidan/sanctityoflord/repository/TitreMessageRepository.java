package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.TitreMessage;
import com.joeladjidan.sanctityoflord.model.TypeEmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitreMessageRepository extends JpaRepository<TitreMessage, Integer> {
    Optional<TitreMessage> findByIntitule(String intitule);
}
