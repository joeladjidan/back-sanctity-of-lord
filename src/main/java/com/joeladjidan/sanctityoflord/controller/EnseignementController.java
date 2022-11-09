package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.EnseignementApi;
import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.services.EnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnseignementController implements EnseignementApi {

  private EnseignementService enseignementService;

  @Autowired
  public EnseignementController(EnseignementService enseignementService) {
    this.enseignementService = enseignementService;
  }

  @Override
  public EnseignementDto save(EnseignementDto dto) {
    return enseignementService.save(dto);
  }

  @Override
  public EnseignementDto findById(Integer id) {
    return enseignementService.findById(id);
  }

  @Override
  public List<EnseignementDto> findAll() {
    return enseignementService.findAll();
  }

  @Override
  public void delete(Integer id) {
    enseignementService.delete(id);
  }
}
