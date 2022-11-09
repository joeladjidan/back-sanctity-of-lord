package com.joeladjidan.sanctityoflord.repository;

import com.joeladjidan.sanctityoflord.model.Emission;
import com.joeladjidan.sanctityoflord.model.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmissionRepository extends JpaRepository<Emission, Integer> {

}
