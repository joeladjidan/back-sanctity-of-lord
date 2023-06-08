package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.PaysDto;

import java.util.List;

public interface PaysService {

  PaysDto enregistrer(PaysDto dto);

  PaysDto findById(Integer id);

  List<PaysDto> findAll();

  void supprimer(Integer id);
}
