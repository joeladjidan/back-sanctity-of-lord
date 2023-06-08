package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.TitreMessageApi;
import com.joeladjidan.sanctityoflord.dto.TitreMessageDto;
import com.joeladjidan.sanctityoflord.services.TitreMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TitreMessageController implements TitreMessageApi {

  private TitreMessageService titreMessageService;

  @Autowired
  public TitreMessageController(TitreMessageService typeEnseignementService) {
    this.titreMessageService = typeEnseignementService;
  }

  @Override
  public TitreMessageDto enregistrer(TitreMessageDto dto) {
    return titreMessageService.save(dto);
  }

  @Override
  public TitreMessageDto findById(Integer id) {
    return titreMessageService.findById(id);
  }

  @Override
  public List<TitreMessageDto> findAll() {
    return titreMessageService.findAll();
  }

  @Override
  public void delete(Integer id) { titreMessageService.delete(id); }
}
