package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.AnneeDto;

import java.util.List;

public interface AnneeService {

  AnneeDto enregistrer(AnneeDto dto);

  AnneeDto findById(Integer id);

  List<AnneeDto> findAll();

  void supprimer(Integer id);
}
