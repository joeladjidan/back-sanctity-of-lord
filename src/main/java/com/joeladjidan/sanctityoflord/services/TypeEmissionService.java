package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.TypeEmissionDto;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;

import java.util.List;

public interface TypeEmissionService {

  TypeEmissionDto save(TypeEmissionDto dto);

  TypeEmissionDto findById(Integer id);

  List<TypeEmissionDto> findAll();

  void delete(Integer id);
}
