package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.CiviliteDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.CIVILITE_ENDPOINT;

@Api("ames")
public interface CiviliteApi {

  @PostMapping(CIVILITE_ENDPOINT + "/enregistrer")
  CiviliteDto enregistrer(@RequestBody CiviliteDto dto);

  @GetMapping(CIVILITE_ENDPOINT + "/{id}")
  CiviliteDto findById(@PathVariable("id") Integer id);

  @GetMapping(CIVILITE_ENDPOINT + "/tous")
  List<CiviliteDto> findAll();

  @DeleteMapping(CIVILITE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
