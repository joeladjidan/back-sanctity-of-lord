package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.AmesDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.AMES_ENDPOINT;

@Api("gestion des personnes a suivre")
public interface AmesApi {

  @PostMapping(AMES_ENDPOINT + "/enregistrer")
  AmesDto enregistrer(@RequestBody AmesDto dto);

  @GetMapping(AMES_ENDPOINT + "/{id}")
  AmesDto findById(@PathVariable("id") Integer id);

  @GetMapping(AMES_ENDPOINT + "/tous")
  List<AmesDto> findAll();

  @DeleteMapping(AMES_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

  @ApiOperation("Obtenir la liste de toutes les personnes suivies de l'eglise")
  @GetMapping(AMES_ENDPOINT + "/report/list")
  void reportListAmes(HttpServletResponse response);

  @ApiOperation("Returns pdf report of students enrolled to a course with a id that is passed as a path variable (from ms faculty)")
  @GetMapping(AMES_ENDPOINT + "/report/details/{id}")
  void reportAmes(@PathVariable("id") Integer id, HttpServletResponse response);
}
