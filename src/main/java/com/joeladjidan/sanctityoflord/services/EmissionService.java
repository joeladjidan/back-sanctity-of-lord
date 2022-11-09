package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import com.joeladjidan.sanctityoflord.dto.EnseignementDto;

import java.util.List;

public interface EmissionService {

  EmissionDto save(EmissionDto dto);

  EmissionDto findById(Integer id);

  List<EmissionDto> findAll();

  void delete(Integer id);
}
