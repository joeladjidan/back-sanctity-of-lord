package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.ArchivreApi;
import com.joeladjidan.sanctityoflord.controller.api.TypeEmissionApi;
import com.joeladjidan.sanctityoflord.dto.ArchivreDto;
import com.joeladjidan.sanctityoflord.dto.TypeEmissionDto;
import com.joeladjidan.sanctityoflord.services.ArchivreService;
import com.joeladjidan.sanctityoflord.services.TypeEmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeEmissionController implements TypeEmissionApi {

  private TypeEmissionService typeEmissionService;

  @Autowired
  public TypeEmissionController(TypeEmissionService typeEmissionService) {
    this.typeEmissionService = typeEmissionService;
  }

  @Override
  public TypeEmissionDto save(TypeEmissionDto dto) {
    return typeEmissionService.save(dto);
  }

  @Override
  public TypeEmissionDto findById(Integer id) {
    return typeEmissionService.findById(id);
  }

  @Override
  public List<TypeEmissionDto> findAll() {
    return typeEmissionService.findAll();
  }

  @Override
  public void delete(Integer id) {
    typeEmissionService.delete(id);
  }
}
