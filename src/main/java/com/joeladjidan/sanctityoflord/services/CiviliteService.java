package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.CiviliteDto;

import java.util.List;

public interface CiviliteService {

  CiviliteDto enregistrer(CiviliteDto dto);

  CiviliteDto findById(Integer id);

  List<CiviliteDto> findAll();

  void supprimer(Integer id);
}
