package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;

import java.util.List;

public interface EnseignementService {

  void supprimer(Integer id);

  List<EnseignementDto> findAll();

  List<EnseignementDto> findByTitreMessageIntituleAndTypeEnseignementIntitule(String titreMessage  , String typeEnseignement);

  EnseignementDto findById(Integer id);

  EnseignementDto enregistrer(EnseignementDto dto);
}
