package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;

import java.util.List;

public interface TypeEnseignementService {

  TypeEnseignementDto save(TypeEnseignementDto dto);

  TypeEnseignementDto findById(Integer id);

  List<TypeEnseignementDto> findAll();

  void delete(Integer id);
}
