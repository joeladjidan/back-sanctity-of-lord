package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.ArchivreDto;
import com.joeladjidan.sanctityoflord.dto.EmissionDto;

import java.util.List;

public interface ArchivreService {

  ArchivreDto save(ArchivreDto dto);

  ArchivreDto findById(Integer id);

  List<ArchivreDto> findAll();

  void delete(Integer id);
}
