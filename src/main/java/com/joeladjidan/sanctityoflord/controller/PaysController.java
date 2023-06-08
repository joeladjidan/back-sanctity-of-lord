package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.PaysApi;
import com.joeladjidan.sanctityoflord.dto.PaysDto;
import com.joeladjidan.sanctityoflord.services.PaysService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des pays" })
@RestController
@Slf4j
public class PaysController implements PaysApi {

  private PaysService paysService;

  @Autowired
  public PaysController(PaysService paysService) {
    this.paysService = paysService;
  }

  @Override
  public PaysDto enregistrer(PaysDto dto) {
    return paysService.enregistrer(dto);
  }

  @Override
  public PaysDto findById(Integer id) {
    return paysService.findById(id);
  }

  @Override
  public List<PaysDto> findAll() {
    return paysService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    paysService.supprimer(id);
  }
}
