package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.AnneeApi;
import com.joeladjidan.sanctityoflord.dto.AnneeDto;
import com.joeladjidan.sanctityoflord.services.AnneeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des années" })
@RestController
@Slf4j
public class AnneeController implements AnneeApi {

  private AnneeService anneeService;

  @Autowired
  public AnneeController(AnneeService anneeService) {
    this.anneeService = anneeService;
  }

  @Override
  public AnneeDto enregistrer(AnneeDto dto) {
    return anneeService.enregistrer(dto);
  }

  @Override
  public AnneeDto findById(Integer id) {
    return anneeService.findById(id);
  }

  @Override
  public List<AnneeDto> findAll() {
    return anneeService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    anneeService.supprimer(id);
  }
}
