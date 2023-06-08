package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.MoisDto;

import java.util.List;

public interface MoisService {

  MoisDto enregistrer(MoisDto dto);

  MoisDto findById(Integer id);

  List<MoisDto> findAll();

  void supprimer(Integer id);
}
