package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.CiviliteApi;
import com.joeladjidan.sanctityoflord.dto.CiviliteDto;
import com.joeladjidan.sanctityoflord.services.CiviliteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CiviliteController implements CiviliteApi {

  private CiviliteService civiliteService;

  @Autowired
  public CiviliteController(CiviliteService civiliteService) {
    this.civiliteService = civiliteService;
  }

  @Override
  public CiviliteDto enregistrer(CiviliteDto dto) {
    return civiliteService.enregistrer(dto);
  }

  @Override
  public CiviliteDto findById(Integer id) {
    return civiliteService.findById(id);
  }

  @Override
  public List<CiviliteDto> findAll() {
    return civiliteService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    civiliteService.supprimer(id);
  }
}
