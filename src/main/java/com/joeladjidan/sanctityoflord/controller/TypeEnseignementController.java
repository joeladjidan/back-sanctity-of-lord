package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.TypeEnseignementApi;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import com.joeladjidan.sanctityoflord.services.TypeEnseignementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TypeEnseignementController implements TypeEnseignementApi {

  private TypeEnseignementService typeEnseignementService;

  @Autowired
  public TypeEnseignementController(TypeEnseignementService typeEnseignementService) {
    this.typeEnseignementService = typeEnseignementService;
  }

  @Override
  public TypeEnseignementDto save(TypeEnseignementDto dto) {
    return typeEnseignementService.save(dto);
  }

  @Override
  public TypeEnseignementDto findById(Integer id) {
    return typeEnseignementService.findById(id);
  }

  @Override
  public List<TypeEnseignementDto> findAll() {
    return typeEnseignementService.findAll();
  }

  @Override
  public void delete(Integer id) { typeEnseignementService.delete(id); }
}
