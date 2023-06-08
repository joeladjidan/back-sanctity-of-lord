package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.AnneeDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ANNEE_ENDPOINT;

@Api("annee")
public interface AnneeApi {

  @PostMapping(ANNEE_ENDPOINT + "/enregistrer")
  AnneeDto enregistrer(@RequestBody AnneeDto dto);

  @GetMapping(ANNEE_ENDPOINT + "/{id}")
  AnneeDto findById(@PathVariable("id") Integer id);

  @GetMapping(ANNEE_ENDPOINT + "/tous")
  List<AnneeDto> findAll();

  @DeleteMapping(ANNEE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
