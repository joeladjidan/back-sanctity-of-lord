package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.EmissionApi;
import com.joeladjidan.sanctityoflord.controller.api.EntrepriseApi;
import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import com.joeladjidan.sanctityoflord.dto.EntrepriseDto;
import com.joeladjidan.sanctityoflord.services.EmissionService;
import com.joeladjidan.sanctityoflord.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmissionController implements EmissionApi {

  private EmissionService emissionService;

  @Autowired
  public EmissionController(EmissionService emissionService) {
    this.emissionService = emissionService;
  }

  @Override
  public EmissionDto save(EmissionDto dto) {
    return emissionService.save(dto);
  }

  @Override
  public EmissionDto findById(Integer id) {
    return emissionService.findById(id);
  }

  @Override
  public List<EmissionDto> findAll() {
    return emissionService.findAll();
  }

  @Override
  public void delete(Integer id) {
    emissionService.delete(id);
  }
}
