package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.ArchivreDto;

import java.util.List;

public interface ArchivreService {

  ArchivreDto save(ArchivreDto dto);

  ArchivreDto findById(Integer id);

  List<ArchivreDto> findAll();

  void delete(Integer id);

  List<ArchivreDto> findByMoisIntituleAndAnneeIntitule(String mois  , String annee);

}
