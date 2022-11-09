package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.GalerieApi;
import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import com.joeladjidan.sanctityoflord.services.GalerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GalerieController implements GalerieApi {

  private GalerieService galerieService;

  @Autowired
  public GalerieController(GalerieService galerieService) {
    this.galerieService = galerieService;
  }

  @Override
  public GalerieDto save(GalerieDto dto) {
    return galerieService.save(dto);
  }

  @Override
  public GalerieDto findById(Integer id) {
    return galerieService.findById(id);
  }

  @Override
  public List<GalerieDto> findAll() {
    return galerieService.findAll();
  }

  @Override
  public void delete(Integer id) {
    galerieService.delete(id);
  }
}
