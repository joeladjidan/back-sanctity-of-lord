package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.AmesApi;
import com.joeladjidan.sanctityoflord.dto.AmesDto;
import com.joeladjidan.sanctityoflord.services.AmesService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = { "Api permettant de gerer les personnes suivies" })
@CrossOrigin(origins = "*")
@RestController
@Slf4j
public class AmesController extends ReportBaseController implements AmesApi  {

  private AmesService amesService;

  @Autowired
  public AmesController(AmesService amesService) {
    this.amesService = amesService;
  }

  @Override
  public AmesDto enregistrer(AmesDto dto) {
    return amesService.enregistrer(dto);
  }

  @Override
  public AmesDto findById(Integer id) {
    return amesService.findById(id);
  }

  @Override
  public List<AmesDto> findAll() {
    return amesService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    amesService.supprimer(id);
  }

  @Override
  public void reportAmes(@PathVariable("id") Integer id, HttpServletResponse response)  {
     amesService.reportAmes(id, response);
  }

  @Override
  public void reportListAmes(HttpServletResponse response) {
      amesService.reportListAmes(response);
  }

}
