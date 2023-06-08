package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.AnnonceDto;

import java.util.List;

public interface AnnonceService {

  AnnonceDto enregistrer(AnnonceDto dto);

  AnnonceDto findById(Integer id);

  List<AnnonceDto> findAll();

  void supprimer(Integer id);
}
