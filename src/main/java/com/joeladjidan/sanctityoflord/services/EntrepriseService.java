package com.joeladjidan.sanctityoflord.services;

import java.util.List;

import com.joeladjidan.sanctityoflord.dto.EntrepriseDto;

public interface EntrepriseService {

  EntrepriseDto save(EntrepriseDto dto);

  EntrepriseDto findById(Integer id);

  List<EntrepriseDto> findAll();

  void delete(Integer id);

}
