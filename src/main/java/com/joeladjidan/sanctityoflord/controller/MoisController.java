package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.MoisApi;
import com.joeladjidan.sanctityoflord.dto.MoisDto;
import com.joeladjidan.sanctityoflord.services.MoisService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des mois" })
@RestController
@Slf4j
public class MoisController implements MoisApi {

  private MoisService moisService;

  @Autowired
  public MoisController(MoisService moisService) {
    this.moisService = moisService;
  }

  @Override
  public MoisDto enregistrer(MoisDto dto) {
    return moisService.enregistrer(dto);
  }

  @Override
  public MoisDto findById(Integer id) {
    return moisService.findById(id);
  }

  @Override
  public List<MoisDto> findAll() {
    return moisService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    moisService.supprimer(id);
  }
}
