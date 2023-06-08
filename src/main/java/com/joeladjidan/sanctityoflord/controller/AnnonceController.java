package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.AnnonceApi;
import com.joeladjidan.sanctityoflord.dto.AnnonceDto;
import com.joeladjidan.sanctityoflord.services.AnnonceService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des annonces" })
@RestController
@Slf4j
public class AnnonceController implements AnnonceApi {

  private AnnonceService annonceService;

  @Autowired
  public AnnonceController(AnnonceService annonceService) {
    this.annonceService = annonceService;
  }

  @Override
  public AnnonceDto enregistrer(AnnonceDto dto) {
    return annonceService.enregistrer(dto);
  }

  @Override
  public AnnonceDto findById(Integer id) {
    return annonceService.findById(id);
  }

  @Override
  public List<AnnonceDto> findAll() {
    return annonceService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    annonceService.supprimer(id);
  }
}
