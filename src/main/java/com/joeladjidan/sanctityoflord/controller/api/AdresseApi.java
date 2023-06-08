package com.joeladjidan.sanctityoflord.controller.api;


import com.joeladjidan.sanctityoflord.dto.AdresseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ADRESSE_ENDPOINT;

@Api("adresse")
public interface AdresseApi {

  @PostMapping(ADRESSE_ENDPOINT + "/enregistrer")
  AdresseDto enregistrer(@RequestBody AdresseDto dto);

  @GetMapping(ADRESSE_ENDPOINT + "/{id}")
  AdresseDto findById(@PathVariable("id") Integer id);

  @GetMapping(ADRESSE_ENDPOINT + "/tous")
  List<AdresseDto> findAll();

  @DeleteMapping(ADRESSE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
