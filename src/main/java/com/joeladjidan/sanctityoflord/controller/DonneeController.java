package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.DonneeApi;
import com.joeladjidan.sanctityoflord.dto.DonneeDto;
import com.joeladjidan.sanctityoflord.services.DonneeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@Slf4j
public class DonneeController implements DonneeApi {

  DonneeService donneeService;

  @Autowired
  public DonneeController(DonneeService donneeService) {
    this.donneeService = donneeService;
  }

  @Override
  public DonneeDto findByFileName(String fileName) {
    return donneeService.findByFileName(fileName);
  }

  @Override
  public DonneeDto modifier(Integer id, DonneeDto dto) {
        return donneeService.modifier(id, dto);
    }

  @Override
  public DonneeDto enregistrer(DonneeDto dto) {
    return donneeService.enregistrer(dto);
  }

  @Override
  public DonneeDto findById(Integer id) {
    return donneeService.findById(id);
  }

  @Override
  public List<DonneeDto> findAll() {
    return donneeService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    donneeService.supprimer(id);
  }

  @Override
  public void reportDonnee(@PathVariable("id") Integer id, HttpServletResponse response)  {
    donneeService.reportDonnee(id, response);
  }
}
