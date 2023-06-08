package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.EnseignementApi;
import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.services.EnseignementService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des enseignements" })
@RestController
@Slf4j
public class EnseignementController implements EnseignementApi {

  private EnseignementService enseignementService;

  @Autowired
  public EnseignementController(EnseignementService enseignementService) {
    this.enseignementService = enseignementService;
  }

  @Override
  public EnseignementDto enregistrer(EnseignementDto dto) {
    return enseignementService.enregistrer(dto);
  }

  @Override
  public EnseignementDto findById(Integer id) {
    return enseignementService.findById(id);
  }

  @Override
  public List<EnseignementDto> findAll() {
      log.info("debut:: recupere la liste de tous les enseignements ");
      List<EnseignementDto> listEnseignementDto = enseignementService.findAll();
      log.info("fin recupere la liste de tous les enseignements  size {} " , listEnseignementDto.size());
      return listEnseignementDto;
  }

  @Override
  public List<EnseignementDto> findByTitreMessageAndTypeEnseignement(String titreMessage, String typeEnseignement) {
      log.info("debut findByTitreMessageAndTypeEnseignement {},{}", titreMessage, typeEnseignement);
      List<EnseignementDto> listEnseignementDto = enseignementService.findByTitreMessageIntituleAndTypeEnseignementIntitule(titreMessage, typeEnseignement);
      log.info("fin findByTitreMessageAndTypeEnseignement {},{}", titreMessage, typeEnseignement);
      return listEnseignementDto;
  }

    @Override
  public void supprimer(Integer id) {
    enseignementService.supprimer(id);
  }
}
