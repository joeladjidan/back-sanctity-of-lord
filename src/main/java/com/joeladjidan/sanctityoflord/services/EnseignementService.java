package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;

import java.util.List;

public interface EnseignementService {

  EnseignementDto save(EnseignementDto dto);

  EnseignementDto findById(Integer id);

  List<EnseignementDto> findAll();

  void delete(Integer id);
}
