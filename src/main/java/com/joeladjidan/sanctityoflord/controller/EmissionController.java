package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.EmissionApi;
import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import com.joeladjidan.sanctityoflord.services.EmissionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des emissions" })
@RestController
@Slf4j
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
    log.info("debut recupere la liste de toute les emissions ");
    List<EmissionDto> listEmission = emissionService.findAll();
    log.info("fin recupere la liste de toute les emissions size {} " , listEmission.size());
    return listEmission;
  }

  @Override
  public void delete(Integer id) {
    emissionService.delete(id);
  }
}
