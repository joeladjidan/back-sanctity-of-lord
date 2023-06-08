package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.MoisDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.MOIS_ENDPOINT;

@Api("mois")
public interface MoisApi {

  @PostMapping(MOIS_ENDPOINT + "/enregistrer")
  MoisDto enregistrer(@RequestBody MoisDto dto);

  @GetMapping(MOIS_ENDPOINT + "/{id}")
  MoisDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = MOIS_ENDPOINT + "/tous", produces="application/json")
  List<MoisDto> findAll();

  @DeleteMapping(MOIS_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
