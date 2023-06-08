package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.VilleApi;
import com.joeladjidan.sanctityoflord.dto.VilleDto;
import com.joeladjidan.sanctityoflord.services.VilleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class VilleController implements VilleApi {

  private VilleService villeService;

  @Autowired
  public VilleController(VilleService villeService) {
    this.villeService = villeService;
  }

  @Override
  public VilleDto enregistrer(VilleDto dto) {
    return villeService.enregistrer(dto);
  }

  @Override
  public VilleDto findById(Integer id) {
    return villeService.findById(id);
  }

  @Override
  public List<VilleDto> findAll() {
    return villeService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    villeService.supprimer(id);
  }
}
