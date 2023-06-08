package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.ArchivreApi;
import com.joeladjidan.sanctityoflord.dto.ArchivreDto;
import com.joeladjidan.sanctityoflord.services.ArchivreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ArchivreController implements ArchivreApi {

  private ArchivreService archivreService;

  @Autowired
  public ArchivreController(ArchivreService archivreService) {
    this.archivreService = archivreService;
  }

  @Override
  public ArchivreDto save(ArchivreDto dto) {
    return archivreService.save(dto);
  }

  @Override
  public ArchivreDto findById(Integer id) {
    return archivreService.findById(id);
  }

  @Override
  public List<ArchivreDto> findAll() {
    return archivreService.findAll();
  }

  @Override
  public List<ArchivreDto> findByMoisAndAnnee(String mois, String annee) {
    return archivreService.findByMoisIntituleAndAnneeIntitule(mois, annee);
  }

  @Override
  public void delete(Integer id) {
    archivreService.delete(id);
  }
}
