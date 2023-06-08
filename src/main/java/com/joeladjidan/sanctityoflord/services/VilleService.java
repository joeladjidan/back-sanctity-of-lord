package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.VilleDto;

import java.util.List;

public interface VilleService {

  VilleDto enregistrer(VilleDto dto);

  VilleDto findById(Integer id);

  List<VilleDto> findAll();

  void supprimer(Integer id);
}
