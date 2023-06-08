package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Donnee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DonneeRepository extends JpaRepository<Donnee, Integer> {
    Donnee findByFileName(String fileName);
}
