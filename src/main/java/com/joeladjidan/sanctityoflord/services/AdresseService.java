package com.joeladjidan.sanctityoflord.services;
import com.joeladjidan.sanctityoflord.dto.AdresseDto;

import java.util.List;

public interface AdresseService {

  AdresseDto enregistrer(AdresseDto dto);

  AdresseDto findById(Integer id);

  List<AdresseDto> findAll();

  void supprimer(Integer id);
}
